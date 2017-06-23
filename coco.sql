/*
Navicat PGSQL Data Transfer

Source Server         : PostgreSql
Source Server Version : 90411
Source Host           : localhost:5432
Source Database       : coco_db
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90411
File Encoding         : 65001

Date: 2017-06-23 09:36:09
*/


-- ----------------------------
-- Sequence structure for tbl_role_role_id_seq
-- ----------------------------
DROP SEQUENCE "public"."tbl_role_role_id_seq";
CREATE SEQUENCE "public"."tbl_role_role_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 2
 CACHE 1;
SELECT setval('"public"."tbl_role_role_id_seq"', 2, true);

-- ----------------------------
-- Sequence structure for tbl_users_id_seq
-- ----------------------------
DROP SEQUENCE "public"."tbl_users_id_seq";
CREATE SEQUENCE "public"."tbl_users_id_seq"
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 2
 CACHE 1;
SELECT setval('"public"."tbl_users_id_seq"', 2, true);

-- ----------------------------
-- Table structure for tbl_role
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_role";
CREATE TABLE "public"."tbl_role" (
"role_id" int4 DEFAULT nextval('tbl_role_role_id_seq'::regclass) NOT NULL,
"role_name" varchar(100) COLLATE "default",
"description" varchar(200) COLLATE "default",
"role_hash" varchar(100) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbl_role
-- ----------------------------
INSERT INTO "public"."tbl_role" VALUES ('1', 'Owner', 'Owner', 'e5255d67-d63d-4c65-ab6b-1065dffd6291');
INSERT INTO "public"."tbl_role" VALUES ('2', 'Admin', 'administration', 'dafe338c-86e7-44dc-8e86-ca721c06370d');

-- ----------------------------
-- Table structure for tbl_users
-- ----------------------------
DROP TABLE IF EXISTS "public"."tbl_users";
CREATE TABLE "public"."tbl_users" (
"id" int4 DEFAULT nextval('tbl_users_id_seq'::regclass) NOT NULL,
"user_name" varchar(100) COLLATE "default",
"gender" varchar(10) COLLATE "default",
"phone" varchar(50) COLLATE "default",
"email" varchar(100) COLLATE "default",
"status" bool,
"user_hash" varchar(100) COLLATE "default",
"user_role" int4,
"create_date" date DEFAULT ('now'::text)::date
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of tbl_users
-- ----------------------------
INSERT INTO "public"."tbl_users" VALUES ('1', 'MN', 'Male', '0567890334', 'yoeurmmany@gmail.com', 't', '679b9d98-0519-43bb-92e1-98de6fbcfc7d', '1');
INSERT INTO "public"."tbl_users" VALUES ('2', 'MK', 'Female', '098345678', 'mk@gmail.com', 't', '9d9cf573-1392-4f89-a28c-47e81cbca1d3', '1');

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
ALTER SEQUENCE "public"."tbl_role_role_id_seq" OWNED BY "tbl_role"."role_id";
ALTER SEQUENCE "public"."tbl_users_id_seq" OWNED BY "tbl_users"."id";

-- ----------------------------
-- Primary Key structure for table tbl_role
-- ----------------------------
ALTER TABLE "public"."tbl_role" ADD PRIMARY KEY ("role_id");

-- ----------------------------
-- Primary Key structure for table tbl_users
-- ----------------------------
ALTER TABLE "public"."tbl_users" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Foreign Key structure for table "public"."tbl_users"
-- ----------------------------
ALTER TABLE "public"."tbl_users" ADD FOREIGN KEY ("user_role") REFERENCES "public"."tbl_role" ("role_id") ON DELETE NO ACTION ON UPDATE NO ACTION;
