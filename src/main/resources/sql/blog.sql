/* 日志表 */
CREATE TABLE `sys_log` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `ip` varchar(20) NOT NULL DEFAULT '' COMMENT '访问者IP',
  `url` varchar(100) NOT NULL DEFAULT '' COMMENT '请求地址',
  `method` varchar(255) NOT NULL DEFAULT '' COMMENT '请求方法',
  `browser` varchar(100) DEFAULT '' COMMENT '浏览器',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 文章类别表 */
CREATE TABLE `blog_category` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `name` varchar(20) NOT NULL COMMENT '分类名称',
  `number` tinyint(10) NOT NULL DEFAULT '0' COMMENT '分类下的文章数量',
  `is_delete` tinyint(1 UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 文章信息表 */
CREATE TABLE `blog_article` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `title` varchar(50) NOT NULL DEFAULT '' COMMENT '文章标题',
  `summary` varchar(300) NOT NULL DEFAULT '' COMMENT '文章简介',
  `page_view` int(10) NOT NULL DEFAULT '0' COMMENT '文章访问量',
  `category_id` bigint UNSIGNED NOT NULL COMMENT '对应分类ID',
  `is_top` tinyint(1) NOT NULL DEFAULT '0' COMMENT '文章是否置顶，默认为0否，1为是',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`) 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 留言、评论表 */
CREATE TABLE `blog_comment` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '昵称',
  `email` varchar(20) NOT NULL DEFAULT '' COMMENT '邮箱',
  `content` varchar(200) NOT NULL DEFAULT '' COMMENT '留言/评论内容',
  `ip` varchar(20) NOT NULL DEFAULT '' COMMENT '留言/评论IP',
  `article_id` bigint UNSIGNED NOT NULL COMMENT '对应分类ID',
  `is_delete` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除，默认为0未删除，1为已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论、留言统一维护';

/* 博客内容表 */
CREATE TABLE `blog_content` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `content` text NOT NULL COMMENT '文章内容',
  `article_id` bigint UNSIGNED NOT NULL COMMENT '对应文章ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/* 博客图片表 */
CREATE TABLE `blog_picture` (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `gmt_create` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `picture_url` varchar(100) NOT NULL DEFAULT '' COMMENT '图片地址',
  `article_id` bigint UNSIGNED NOT NULL COMMENT '对应文章ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客图片';