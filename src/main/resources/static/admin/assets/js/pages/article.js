$(document).ready(function () {
    // 填充博文分类信息
    $.ajax({
        url: "/categories",
        type: "GET",
        dataType: "json",
        success: function (result) {
            $.each(result.data, function (i, item) {
                $('#articleCategories').append('<option categoryId="' + item.id + '">' + item.name + '</option>');
                $('#addCategories').append('<option categoryId="' + item.id + '">' + item.name + '</option>');
            });
        }
    });

    // 填充博文列表信息
    $.ajax({
        type: "get",
        url: "/articles",
        dataType: "json",
        success: function (result) {
            $.each(result.data, function (i, item) {
                $('#tbody-articles').append(
                    '<tr><td>' + +item.id +
                    '</td><td>' + item.title +
                    '</td><td>' + item.top +
                    '</td><td>' + item.pageView +
                    '</td><td><a href="' + item.pictureUrl + '">点击这里</a></td>' +
                    '</td><td>' + item.delete +
                    '<td><button class="btn btn-success" onclick="updateArticle(' + item.id + ')"><i class="fa fa-edit"></i> 编辑</button> ' +
                    '<button class="btn btn-danger" onclick="deleteArticle(' + item.id + ')"><i class="fa fa-trash-o"> 删除</i></button></td></tr>');
            });
            $('#dataTables-articles').dataTable();
        }
    });


});

// 监听博文分类Select改变，改变注入相应的博文
document.getElementById("articleCategories").onchange = function () {
    var categoryId = $('#articleCategories option:selected').attr("categoryId");
    //	alert(categoryId);
    if (categoryId === "") {
        var url = "/articles";
    } else {
        var url = "/admin/articles/" + categoryId;
    }
    // 填充博文分类信息
    $.ajax({
        url: url,
        type: "GET",
        dataType: "json",
        success: function (result) {
            // 先清空博文数据
            $('#tbody-articles').html("");
            $.each(result.data, function (i, item) {
                $('#tbody-articles').append(
                    '<td><td>' + +item.id +
                    '</td><td>' + item.title +
                    '</td><td>' + item.top +
                    '</td><td>' + item.pageView +
                    '</td><td><a href="' + item.pictureUrl + '">点击这里</a></td>' +
                    '</td><td>' + item.delete +
                    '<td><button class="btn btn-success" onclick="updateArticle(' + item.id + ')"><i class="fa fa-edit"></i> 编辑</button> ' +
                    '<button class="btn btn-danger" onclick="deleteArticle(' + item.id + ')"><i class="fa fa-trash-o"> 删除</i></button></td></tr>');
            });
            $('#dataTables-articles').dataTable();

        }
    });

};

// 删除按钮点击
function deleteArticle(articleId) {
    $('#confirmBtn').attr("articleId", articleId);
    $('#myModal').modal();
};

// 编辑文章按钮点击
function updateArticle(articleId) {
    // 往模态框填充数据
    $('#updateBtn').attr("articleId", articleId);
    $.ajax({
        type: "get",
        url: "/articles/" + articleId,
        dataType: "json",
        async: false,
        success: function (result) {
            $('#articleTitle').val(result.data.title);
            $('#articleSummary').val(result.data.summary);
            if (result.data.top == true) {
                document.getElementById("articleTop").checked = true;
            }
            // 填充分类数据
            $.ajax({
                url: "/categories",
                type: "GET",
                dataType: "json",
                async: false,
                success: function (result) {
                    $('#updateCategories').html("");
                    $.each(result.data, function (i, item) {
                        $('#updateCategories').append('<option categoryId="' + item.id + '">' + item.name + '</option>');
                    });
                }
            });
            var select = document.getElementById("updateCategories");
            var index;
            for (var i = 0; i < select.options.length; i++) {
                if (select.options[i].innerHTML == result.data.categoryId) {
                    //					alert(i);
                    //					alert(select.options[i].innerHTML);
                    //					alert(json.categoryName);
                    select.options[i].selected = true;
                    break;
                }
            }
            $('#articlePicture').val(result.data.pictureUrl);
            $('#articleContent').val(result.data.content);
        }
    });

    // 显示模态框
    $('#updateModal').modal();
};

// 更新文章按钮点击事件
$('#updateBtn').click(function () {
    var articleId = $('#updateBtn').attr("articleId");
    var articleTitle = $('#articleTitle').val();
    var articleSummary = $("#articleSummary").val();
    //	if(document.getElementById("articleTop").checked == true) {
    //		var articleTop = 1;
    //		alert("")
    //	} else {
    //		var articleTop = 0;
    //	}
    var articleTop = document.getElementById("articleTop").checked;
    //	alert(articleTop);
    var articleCategoryId = $("#updateCategories option:selected").attr("categoryId");
    var articlePicture = $('#articlePicture').val();
    var articleContent = $('#articleContent').val();
    var article = {
        id: articleId,
        title: articleTitle,
        summary: articleSummary,
        top: articleTop,
        categoryId: articleCategoryId,
        pictureUrl: articlePicture,
        content: articleContent
    }
    $.ajax({
        type: "PUT",
        url: "/admin/articles/" + articleId,
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(article),
        success: function () {
            location.reload();
        },
        error: function () {
            location.reload();
        }
    });
});

// 确认删除按钮点击
$('#confirmBtn').click(function () {
    var articleId = $(this).attr("articleId");
    $.ajax({
        type: "DELETE",
        url: "/admin/articles/" + articleId,
        success: function () {
            // 刷新页面
            alert("hhhh");
            location.reload();
        }
    });
});

// 增加文章按钮点击事件
$('#addArticleBtn').click(function () {
    var articleTitle = $('#addArticleTitle').val();
    var articleSummary = $("#addArticleSummary").val();
    var articleTop = document.getElementById("addArticleTop").checked;
    //	alert(articleTop);
    var articleCategoryId = $("#addCategories option:selected").attr("categoryId");
    var articlePicture = $('#addArticlePicture').val();
    var articleContent = $('#addArticleContent').val();
    var article = {
        title: articleTitle,
        summary: articleSummary,
        top: articleTop,
        categoryId: articleCategoryId,
        pictureUrl: articlePicture,
        content: articleContent
    }
    $.ajax({
        type: "POST",
        url: "/admin/article",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(article),
        success: function () {
            location.reload();
        },
        error: function () {
            location.reload();
        }
    });
});
