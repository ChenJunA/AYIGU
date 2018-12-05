$(document).ready(function () {
    // 填充浏览统计数据
    $.ajax({
        url: "/admin/log",
        type: "GET",
        dataType: "json",
        success: function (result) {
            $('#count-visits').append(result.data.length)
            $.each(result.data, function (i, item) {
                $('#tbody-visits').append(
                    '<tr><td>' + item.id +
                    '</td><td>' + item.ip +
                    '</td><td>' + item.gmtCreate + '</td></tr>');
            });
            $('#dataTables-visits').dataTable();
        }
    });

    // 填充日志统计数据
    $.ajax({
        url: "/admin/log",
        type: "GET",
        dataType: "json",
        success: function (result) {
            $('#count-logs').append(result.data.length)
            $.each(result.data, function (i, item) {
                $('#tbody-logs').append(
                    '<tr><td>' + item.id +
                    '</td><td>' + item.ip +
                    '</td><td>' + item.gmtCreate +
                    '</td><td>' + item.method +
                    '</td><td>' + item.url +
                    '</td><td>' + item.browser + '</td></tr>');
            });
            $('#dataTables-logs').dataTable();
        }
    });

    // 填充评论统计数据
    $.ajax({
        url: "/admin/comments",
        type: "GET",
        dataType: "json",
        success: function (result) {
            $('#count-comments').append(result.data.length)
            $.each(result.data, function (i, item) {
                $('#tbody-comments').append(
                    '<tr><td>' + item.id +
                    '</td><td>' + item.content +
                    '</td><td>' + item.gmtCreate +
                    '</td><td>' + item.name +
                    '</td><td>' + item.ip +
                    '</td><td>' + item.isDelete +
                    '</td><td><button class="btn btn-danger deleteBtn" onclick="deleteComment(\'' + item.id + '\')"><i class="fa fa-trash-o"></i>删除</button></td></tr>');

            });
            $('#dataTables-comments').dataTable();
        }
    });

    // 确认删除留言点击事件
    $('#confirmBtn').click(function () {
        var commentId = $(this).attr("commentId");
        $.ajax({
            type: "DELETE",
            url: "/admin/comments/" + commentId,
            success: function () {
                // 刷新页面
                location.reload();
            }
        });
    });
});

// 删除评论
function deleteComment(id) {
    $('#confirmBtn').attr("commentId", id);
    $('#myModal').modal();
    alert("222");
};

