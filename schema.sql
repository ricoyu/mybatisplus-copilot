/*
 Navicat Premium Dump SQL

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50742 (5.7.42-0ubuntu0.18.04.1)
 Source Host           : localhost:3306
 Source Schema         : poem_db

 Target Server Type    : MySQL
 Target Server Version : 50742 (5.7.42-0ubuntu0.18.04.1)
 File Encoding         : 65001

 Date: 18/02/2025 21:08:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作者姓名',
  `dynasty` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '朝代',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '作者简介',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '作者表' ROW_FORMAT = Dynamic;

INSERT INTO `author` (`name`, `dynasty`, `description`) VALUES
                                                            ('李白', '唐代', '唐代著名浪漫主义诗人，被誉为“诗仙”。'),
                                                            ('杜甫', '唐代', '唐代著名现实主义诗人，被誉为“诗圣”。'),
                                                            ('白居易', '唐代', '唐代著名诗人，主张“文章合为时而著，歌诗合为事而作”。'),
                                                            ('苏轼', '宋代', '宋代著名文学家、书画家，唐宋八大家之一。'),
                                                            ('辛弃疾', '宋代', '宋代著名词人，豪放派代表人物。'),
                                                            ('李清照', '宋代', '宋代著名女词人，婉约派代表人物。'),
                                                            ('王之涣', '唐代', '唐代著名诗人，以边塞诗著称。'),
                                                            ('孟浩然', '唐代', '唐代著名山水田园诗人。'),
                                                            ('柳宗元', '唐代', '唐代著名文学家、哲学家，唐宋八大家之一。'),
                                                            ('陆游', '宋代', '宋代著名诗人，爱国诗人代表。'),
                                                            ('欧阳修', '宋代', '宋代著名文学家、史学家，唐宋八大家之一。'),
                                                            ('王安石', '宋代', '宋代著名政治家、文学家，唐宋八大家之一。'),
                                                            ('李商隐', '唐代', '唐代著名诗人，擅长写爱情诗和无题诗。'),
                                                            ('杜牧', '唐代', '唐代著名诗人，擅长写咏史诗。'),
                                                            ('王维', '唐代', '唐代著名诗人、画家，被誉为“诗佛”。'),
                                                            ('刘禹锡', '唐代', '唐代著名诗人，擅长写咏史诗和山水诗。'),
                                                            ('范仲淹', '宋代', '宋代著名政治家、文学家，以《岳阳楼记》闻名。'),
                                                            ('晏殊', '宋代', '宋代著名词人，婉约派代表人物。'),
                                                            ('秦观', '宋代', '宋代著名词人，婉约派代表人物。'),
                                                            ('黄庭坚', '宋代', '宋代著名诗人、书法家，江西诗派代表人物。');

-- ----------------------------
-- Records of author
-- ----------------------------

-- ----------------------------
-- Table structure for poem
-- ----------------------------
DROP TABLE IF EXISTS `poem`;
CREATE TABLE `poem`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '诗词标题',
  `author` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '作者',
  `content` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '诗词内容',
  `dynasty` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '朝代',
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `is_deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除标志（0：未删除，1：已删除）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '古诗词表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of poem
-- ----------------------------
INSERT INTO `poem` VALUES (1, '静夜思', '李白', '床前明月光，疑是地上霜。举头望明月，低头思故乡。', '唐代', '2025-02-18 20:33:59', '2025-02-18 20:33:59', 0);
INSERT INTO `poem` VALUES (2, '登鹳雀楼', '王之涣', '白日依山尽，黄河入海流。欲穷千里目，更上一层楼。', '唐代', '2025-02-18 20:33:59', '2025-02-18 20:33:59', 0);
INSERT INTO `poem` VALUES (3, '春晓', '孟浩然', '春眠不觉晓，处处闻啼鸟。夜来风雨声，花落知多少。', '唐代', '2025-02-18 20:33:59', '2025-02-18 20:33:59', 0);
INSERT INTO `poem` VALUES (4, '江雪', '柳宗元', '千山鸟飞绝，万径人踪灭。孤舟蓑笠翁，独钓寒江雪。', '唐代', '2025-02-18 20:33:59', '2025-02-18 20:33:59', 0);
INSERT INTO `poem` VALUES (5, '望庐山瀑布', '李白', '日照香炉生紫烟，遥看瀑布挂前川。飞流直下三千尺，疑是银河落九天。', '唐代', '2025-02-18 20:33:59', '2025-02-18 20:33:59', 0);

SET FOREIGN_KEY_CHECKS = 1;
