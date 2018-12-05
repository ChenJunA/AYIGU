$(document).ready(function() {
	// 填充浏览统计数据
	$.ajax({
		url: "/categories",
		type: "GET",
		dataType: "json",
		success: function(result) {
			$.each(result.data, function(i, item) {
				$('#tbody-categoris').append(
					'<tr><td>' + +item.id +
					'</td><td>' + item.name +
					'</td><td>' + item.number +
					'</td><td>' + item.gmtCreate +
					'</td><td>' + item.gmtModified +
					'</td><td>' + item.isDelete +
					'</td><td><button class="btn btn-danger deleteBtn" onclick="deleteCategory(\'' + item.id + '\')"><i class="fa fa-trash-o"></i>删除</button></td></tr>');
				$('#select-category').append(
					'<option categoryId="' + item.id + '">' + item.name + '</option>'
				);
			});
			$('#dataTables-categoris').dataTable();
		}
	});

    // 确认删除按钮点击事件
    $('#confirmBtn').click(function() {
        var categoryId = $(this).attr("categoryId");
        $.ajax({
            type: "DELETE",
            url: "/admin/categories/" + categoryId,
            success: function() {
                // 刷新页面
                location.reload();
            }
        });
    });

    // 增加分类按钮点击事件
    $('#addCategoryBtn').click(function() {
        var categoryName = $('#addName').val();
        var json = {
            name: categoryName
        };
        $.ajax({
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            url: "/admin/category",
            data: JSON.stringify(json),
            success: function() {
                // 刷新页面
                location.reload();
            },
            error: function() {
                location.reload();
            }
        });
        return false;
    });

// 更新分类点击事件
    $('#updateCategoryBtn').click(function() {
        var categoryId = $('#select-category option:selected').attr("categoryId");
        var categoryName = $('#updateName').val();
        var categoryJson = {
            id: categoryId,
            name: categoryName
        };
        $.ajax({
            type: "PUT",
            url: "/admin/categories/" + categoryId,
            data: JSON.stringify(categoryJson),
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function() {
                // 刷新页面
                location.reload();
            },
            error: function() {
                $('#updateName').val("");
                location.reload();
            }
        })
    });
});

// 删除按钮点击事件
function deleteCategory(categoryId) {
	$('#confirmBtn').attr("categoryId", categoryId);
	$('#myModal').modal();
};


