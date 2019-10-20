INSERT INTO `t_role` VALUES ('e53c757f-f229-11e9-87a9-c4346b03821a', 'app', '应用人员');
INSERT INTO `t_role` VALUES ('f8ee6553-f229-11e9-87a9-c4346b03821a', 'admin', '管理员');

INSERT INTO `t_user` VALUES ('8c7b73c2-f229-11e9-87a9-c4346b03821a', '办公室/张三', '张三');
INSERT INTO `t_user` VALUES ('a296ba95-f229-11e9-87a9-c4346b03821a', '办公室/李四', '李四');
INSERT INTO `t_user` VALUES ('b30f826a-f229-11e9-87a9-c4346b03821a', '数据中心/王五', '王五');
INSERT INTO `t_user` VALUES ('ceeba5be-f229-11e9-87a9-c4346b03821a', '数据中心/孙七', '孙七');

INSERT INTO `t_user_role` VALUES ('b30f826a-f229-11e9-87a9-c4346b03821a', 'e53c757f-f229-11e9-87a9-c4346b03821a');
INSERT INTO `t_user_role` VALUES ('ceeba5be-f229-11e9-87a9-c4346b03821a', 'e53c757f-f229-11e9-87a9-c4346b03821a');
INSERT INTO `t_user_role` VALUES ('8c7b73c2-f229-11e9-87a9-c4346b03821a', 'f8ee6553-f229-11e9-87a9-c4346b03821a');
INSERT INTO `t_user_role` VALUES ('a296ba95-f229-11e9-87a9-c4346b03821a', 'f8ee6553-f229-11e9-87a9-c4346b03821a');
