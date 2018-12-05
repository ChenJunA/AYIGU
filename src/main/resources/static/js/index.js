// 页面初始化：填充数据
window.onload = function() {
	$.ajax({
		url: "articles/lastest",
		type: "GET",
		dataType: "json",
		success: function(result) {
			$.each(result.data, function(i, item) {
				// 设置右下角题图的内容
				$(".smallPictures img[location=" + i + "]").attr("src", item.pictureUrl);
				$(".smallPictures img[location=" + i + "]").attr("pictureUrl", item.pictureUrl);
				$(".smallPictures img[location=" + i + "]").attr("articleId", item.id);
				$(".smallPictures img[location=" + i + "]").attr("title", item.title);
				$(".smallPictures img[location=" + i + "]").attr("summary", item.summary);

				// 默认显示第一篇文章的信息
				if(i == "0") {
					$("#articleTitle").html(item.title);
					$("#articleSummary").html(item.summary);
					$("#articlePicture img").attr("src", item.pictureUrl);
					$("#showArticle").attr("articleId", item.id);
				}
			});
		}
	});
};

// 按钮点击进行文章详情页
$("#showArticle").click(function() {
	var articleId = $(this).attr("articleId");
	var url = "article.html?articleId=" + articleId;
	window.location.href = url;
});

// 缩略图鼠标进入事件：更换大图和按钮的articleId
$(".smallPictures img").mouseenter(function() {
	var pictureUrl = $(this).attr("pictureUrl");
	var articleId = $(this).attr("articleId")
	var title = $(this).attr("title");
	var summary = $(this).attr("summary");
	$("#articlePicture img").attr("src", pictureUrl);
	$("#showArticle").attr("articleId", articleId);
	$("#articleTitle").html(title);
	$("#articleSummary").html(summary);
});
