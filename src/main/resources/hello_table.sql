/*
 Navicat Premium Data Transfer

 Source Server         : gapi
 Source Server Type    : SQLite
 Source Server Version : 3008004
 Source Database       : main

 Target Server Type    : SQLite
 Target Server Version : 3008004
 File Encoding         : utf-8

 Date: 01/20/2018 14:01:24 PM
*/

PRAGMA foreign_keys = false;

-- ----------------------------
--  Table structure for hello_table
-- ----------------------------
DROP TABLE IF EXISTS "hello_table";
CREATE TABLE "hello_table" (
	 "PK_Id" integer,
	 "Name" text(500,0),
	 "Age" integer,
	PRIMARY KEY("PK_Id")
);

-- ----------------------------
--  Records of hello_table
-- ----------------------------
BEGIN;
INSERT INTO "hello_table" VALUES (871226111, 'name871226111', 871226111);
INSERT INTO "hello_table" VALUES (1397989760, 'name1397989760', 1397989760);
INSERT INTO "hello_table" VALUES (1609570241, 'name + 1609570241', 1609570241);
COMMIT;

PRAGMA foreign_keys = true;
