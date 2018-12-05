window.onload = function () {
    // 获取留言信息
    $.ajax({
        url: "/comments/23333",
        type: "GET",
        dataType: "json",
        success: function (result) {
            $.each(result.data, function (i, item) {
                $('#commentList').append(
                    '<div class="comment">' +
                    '<label class="commentName">' + item.name + '</label> <label class="commentTime">' + item.gmtCreate + '</label><br />' +
                    '<lable class="commentContent">' + item.content + '</lable>' +
                    '</div></div>'
                );
            });
        }
    })
};

// 增加留言
$('#addComment').click(function () {
    var name = $('#commentName').val();
    var email = $('#commentEmail').val();
    var content = $('#commentContent').val();

    // 判断是否为空
    if ("" == name || "" == content) {
        $('#modal').modal();
        return;
    }

    // 不为空才能增加
    var comment = {
        name: name,
        email: email,
        content: content
    }
    // 提交AJAX请求
    $.ajax({
        url: "/comment/23333",
        type: "POST",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        data: JSON.stringify(comment),
        success: function () {
            // 显示成功提示信息
            $('#addModal').modal();
        },
        error: function () {
            // 显示成功提示信息
            $('#addModal').modal();
        }
    })
});

// 模态框确认按钮点击事件
$('#addConfirmBtn').click(function () {
    // 刷新页面
    location.reload();
});