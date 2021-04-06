/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.2.173
 Source Server Type    : PostgreSQL
 Source Server Version : 80323
 Source Host           : 192.168.2.173:5432
 Source Catalog        : gas_zkpt
 Source Schema         : gas_ods

 Target Server Type    : PostgreSQL
 Target Server Version : 80323
 File Encoding         : 65001

 Date: 20/06/2020 17:41:19
*/


-- ----------------------------
-- Sequence structure for hn_gas_gsj_reg_marpripinfo_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."hn_gas_gsj_reg_marpripinfo_shard_id_seq";
CREATE SEQUENCE "gas_ods"."hn_gas_gsj_reg_marpripinfo_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for jcsj_bgd_sc_shard_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."jcsj_bgd_sc_shard_seq";
CREATE SEQUENCE "gas_ods"."jcsj_bgd_sc_shard_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for jcsj_bgd_wm_shard_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."jcsj_bgd_wm_shard_seq";
CREATE SEQUENCE "gas_ods"."jcsj_bgd_wm_shard_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_dw_company
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."seq_dw_company";
CREATE SEQUENCE "gas_ods"."seq_dw_company" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for seq_dw_person
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."seq_dw_person";
CREATE SEQUENCE "gas_ods"."seq_dw_person" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_bmjgx_gsj_bgxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_bmjgx_gsj_bgxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_bmjgx_gsj_bgxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_bmjgx_gsj_djxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_bmjgx_gsj_djxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_bmjgx_gsj_djxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_crj_zsryjbxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_crj_zsryjbxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_crj_zsryjbxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_dzxxb_dispatch_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_dzxxb_dispatch_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_dzxxb_dispatch_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_gs_bgmx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_gs_bgmx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_gs_bgmx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_gs_fddb_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_gs_fddb_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_gs_fddb_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_gs_gdml_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_gs_gdml_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_gs_gdml_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_gs_glry_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_gs_glry_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_gs_glry_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_gs_jyycmlxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_gs_jyycmlxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_gs_jyycmlxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_gs_zt_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_gs_zt_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_gs_zt_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_gs_zxsh_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_gs_zxsh_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_gs_zxsh_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_gs_zxsl_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_gs_zxsl_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_gs_zxsl_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_hg_fhngqbgd_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_hg_fhngqbgd_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_hg_fhngqbgd_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_hg_fhngqsd_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_hg_fhngqsd_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_hg_fhngqsd_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_hg_hngqbgd_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_hg_hngqbgd_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_hg_hngqbgd_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_hg_hngqsd_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_hg_hngqsd_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_hg_hngqsd_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_hg_swckts_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_hg_swckts_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_hg_swckts_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jcd_gt_tldp_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jcd_gt_tldp_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jcd_gt_tldp_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jcd_hngh_lkjp_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jcd_hngh_lkjp_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jcd_hngh_lkjp_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jcd_hngh_lksp_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jcd_hngh_lksp_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jcd_hngh_lksp_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jcd_kjhaxgcpsj_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jcd_kjhaxgcpsj_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jcd_kjhaxgcpsj_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jcd_kxj_mhlg_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jcd_kxj_mhlg_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jcd_kxj_mhlg_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jcd_kxj_xjcdajxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jcd_kxj_xjcdajxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jcd_kxj_xjcdajxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jcd_kxj_xjcdxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jcd_kxj_xjcdxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jcd_kxj_xjcdxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jcd_kxj_xjcdxxjcaj_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jcd_kxj_xjcdxxjcaj_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jcd_kxj_xjcdxxjcaj_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jcd_xygldsmzspryxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jcd_xygldsmzspryxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jcd_xygldsmzspryxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jcd_xygldsmzspryxxkp_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jcd_xygldsmzspryxxkp_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jcd_xygldsmzspryxxkp_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jcd_yxgghsjxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jcd_yxgghsjxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jcd_yxgghsjxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jcd_zj_haxgcp_car_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jcd_zj_haxgcp_car_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jcd_zj_haxgcp_car_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jj_hkddc_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jj_hkddc_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jj_hkddc_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_js_jds_csryxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_js_jds_csryxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_js_jds_csryxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jz_aj_th_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jz_aj_th_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jz_aj_th_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jz_aj_thglaj_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jz_aj_thglaj_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jz_aj_thglaj_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jz_aj_thglcy_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jz_aj_thglcy_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jz_aj_thglcy_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jz_ry_swxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jz_ry_swxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jz_ry_swxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_jz_ry_zdrksp_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_jz_ry_zdrksp_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_jz_ry_zdrksp_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_qb_qgzdryxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_qb_qgzdryxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_qb_qgzdryxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_sf_glry_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_sf_glry_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_sf_glry_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_wh_cksh_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_wh_cksh_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_wh_cksh_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_wh_dgfk_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_wh_dgfk_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_wh_dgfk_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_wh_dgsr_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_wh_dgsr_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_wh_dgsr_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_wh_jkfh_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_wh_jkfh_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_wh_jkfh_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_xj_qgztryxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_xj_qgztryxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_xj_qgztryxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_xjz_zfrxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_xjz_zfrxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_xjz_zfrxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_za_gnlkrzxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_za_gnlkrzxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_za_gnlkrzxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_za_ldjbxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_za_ldjbxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_za_ldjbxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Sequence structure for t_za_ldrkxx_shard_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "gas_ods"."t_za_ldrkxx_shard_id_seq";
CREATE SEQUENCE "gas_ods"."t_za_ldrkxx_shard_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
CACHE 1;

-- ----------------------------
-- Table structure for dw_company
-- ----------------------------
DROP TABLE IF EXISTS "gas_ods"."dw_company";
CREATE TABLE "gas_ods"."dw_company" (
  "shard_id" int8 NOT NULL DEFAULT nextval('"gas_ods".seq_dw_company'::regclass),
  "tyshxydm" varchar(20),
  "gszchm" varchar(20),
  "zzjgdm" varchar(20),
  "qymc" varchar(200) NOT NULL,
  "zzjgdmzfzjg" varchar(100),
  "wzzch" varchar(10),
  "nsrsbh" varchar(50),
  "yyzzhm" varchar(50),
  "swh" varchar(20),
  "gsnshm" varchar(20),
  "dsnshm" varchar(21),
  "lsgx" varchar(200),
  "gb" varchar(50),
  "sfmc" varchar(100),
  "xzqh" varchar(100),
  "qylx" varchar(100),
  "dwlx" varchar(100),
  "hylb" varchar(10),
  "hyxl" varchar(50),
  "jyfw" varchar(4000),
  "jycs" varchar(100),
  "wzcy" varchar(10),
  "qylxdl" varchar(40),
  "qylxzl" varchar(40),
  "qylxxl" varchar(40),
  "frmc" varchar(200),
  "frzjhm" varchar(50),
  "frzjlx" varchar(100),
  "clrq" varchar(150),
  "zczb" varchar(50),
  "wfzczb" varchar(10),
  "zczbbz" varchar(30),
  "wfzczbbz" varchar(30),
  "tzze" varchar(15),
  "tzbz" varchar(30),
  "djbz" varchar(10),
  "wzdz" varchar(50),
  "lxdh" varchar(30),
  "qyyx" varchar(100),
  "qydz" varchar(1500),
  "zgjg" varchar(100),
  "zgswj" varchar(100),
  "jyksrq" varchar(10),
  "jyjsrq" varchar(10),
  "yxqq" varchar(10),
  "yxqz" varchar(10),
  "djjg" varchar(100),
  "hzrq" varchar(10),
  "zxrq" varchar(10),
  "dxrq" varchar(10),
  "zzxs" varchar(50),
  "jgqy" varchar(150),
  "fxhy" varchar(50),
  "jyfs" varchar(50),
  "djzt" varchar(20),
  "crsj" timestamp(0) NOT NULL DEFAULT '2018-11-13 16:21:34.915422'::timestamp without time zone,
  "lyb" varchar(31) NOT NULL,
  "lyzd" varchar(31) NOT NULL
)
;
COMMENT ON COLUMN "gas_ods"."dw_company"."shard_id" IS '分片id';
COMMENT ON COLUMN "gas_ods"."dw_company"."tyshxydm" IS '统一社会信用代码';
COMMENT ON COLUMN "gas_ods"."dw_company"."gszchm" IS '工商注册号码';
COMMENT ON COLUMN "gas_ods"."dw_company"."zzjgdm" IS '组织机构代码';
COMMENT ON COLUMN "gas_ods"."dw_company"."qymc" IS '企业名称';
COMMENT ON COLUMN "gas_ods"."dw_company"."zzjgdmzfzjg" IS '组织机构代码证颁发机关';
COMMENT ON COLUMN "gas_ods"."dw_company"."wzzch" IS '外资专用注册号';
COMMENT ON COLUMN "gas_ods"."dw_company"."nsrsbh" IS '纳税人识别号';
COMMENT ON COLUMN "gas_ods"."dw_company"."yyzzhm" IS '营业执照号码';
COMMENT ON COLUMN "gas_ods"."dw_company"."swh" IS '税务号';
COMMENT ON COLUMN "gas_ods"."dw_company"."gsnshm" IS '国税纳税号码';
COMMENT ON COLUMN "gas_ods"."dw_company"."dsnshm" IS '地税纳税号码';
COMMENT ON COLUMN "gas_ods"."dw_company"."lsgx" IS '隶属关系';
COMMENT ON COLUMN "gas_ods"."dw_company"."gb" IS '国别';
COMMENT ON COLUMN "gas_ods"."dw_company"."sfmc" IS '省份名称';
COMMENT ON COLUMN "gas_ods"."dw_company"."xzqh" IS '行政区划';
COMMENT ON COLUMN "gas_ods"."dw_company"."qylx" IS '企业类型';
COMMENT ON COLUMN "gas_ods"."dw_company"."dwlx" IS '单位类型';
COMMENT ON COLUMN "gas_ods"."dw_company"."hylb" IS '行业类别';
COMMENT ON COLUMN "gas_ods"."dw_company"."hyxl" IS '行业细类';
COMMENT ON COLUMN "gas_ods"."dw_company"."jyfw" IS '经营范围';
COMMENT ON COLUMN "gas_ods"."dw_company"."jycs" IS '经营场所';
COMMENT ON COLUMN "gas_ods"."dw_company"."wzcy" IS '外资产业';
COMMENT ON COLUMN "gas_ods"."dw_company"."qylxdl" IS '企业类型大类';
COMMENT ON COLUMN "gas_ods"."dw_company"."qylxzl" IS '企业类型中类';
COMMENT ON COLUMN "gas_ods"."dw_company"."qylxxl" IS '企业类型小类';
COMMENT ON COLUMN "gas_ods"."dw_company"."frmc" IS '法人名称';
COMMENT ON COLUMN "gas_ods"."dw_company"."frzjhm" IS '法人证件号码';
COMMENT ON COLUMN "gas_ods"."dw_company"."frzjlx" IS '法人证件类型';
COMMENT ON COLUMN "gas_ods"."dw_company"."clrq" IS '成立日期';
COMMENT ON COLUMN "gas_ods"."dw_company"."zczb" IS '注册资本';
COMMENT ON COLUMN "gas_ods"."dw_company"."wfzczb" IS '注册资本（外方）';
COMMENT ON COLUMN "gas_ods"."dw_company"."zczbbz" IS '注册资本币种';
COMMENT ON COLUMN "gas_ods"."dw_company"."wfzczbbz" IS '注册资本币种（外方）';
COMMENT ON COLUMN "gas_ods"."dw_company"."tzze" IS '投资总额';
COMMENT ON COLUMN "gas_ods"."dw_company"."tzbz" IS '投资币种';
COMMENT ON COLUMN "gas_ods"."dw_company"."djbz" IS '登记币种';
COMMENT ON COLUMN "gas_ods"."dw_company"."wzdz" IS '网站地址';
COMMENT ON COLUMN "gas_ods"."dw_company"."lxdh" IS '联系电话';
COMMENT ON COLUMN "gas_ods"."dw_company"."qyyx" IS '企业邮箱';
COMMENT ON COLUMN "gas_ods"."dw_company"."qydz" IS '企业地址';
COMMENT ON COLUMN "gas_ods"."dw_company"."zgjg" IS '主管机关';
COMMENT ON COLUMN "gas_ods"."dw_company"."zgswj" IS '主管税务局';
COMMENT ON COLUMN "gas_ods"."dw_company"."jyksrq" IS '经营开始日期';
COMMENT ON COLUMN "gas_ods"."dw_company"."jyjsrq" IS '经营结束日期';
COMMENT ON COLUMN "gas_ods"."dw_company"."yxqq" IS '有效期起';
COMMENT ON COLUMN "gas_ods"."dw_company"."yxqz" IS '有效期止';
COMMENT ON COLUMN "gas_ods"."dw_company"."djjg" IS '登记机关';
COMMENT ON COLUMN "gas_ods"."dw_company"."hzrq" IS '核准日期';
COMMENT ON COLUMN "gas_ods"."dw_company"."zxrq" IS '注销日期';
COMMENT ON COLUMN "gas_ods"."dw_company"."dxrq" IS '吊销日期';
COMMENT ON COLUMN "gas_ods"."dw_company"."zzxs" IS '组织形式';
COMMENT ON COLUMN "gas_ods"."dw_company"."jgqy" IS '监管区域';
COMMENT ON COLUMN "gas_ods"."dw_company"."fxhy" IS '风险行业';
COMMENT ON COLUMN "gas_ods"."dw_company"."jyfs" IS '经营方式';
COMMENT ON COLUMN "gas_ods"."dw_company"."djzt" IS '登记状态';
COMMENT ON COLUMN "gas_ods"."dw_company"."crsj" IS '插入时间';
COMMENT ON COLUMN "gas_ods"."dw_company"."lyb" IS '来源表';
COMMENT ON COLUMN "gas_ods"."dw_company"."lyzd" IS '来源字段';
COMMENT ON TABLE "gas_ods"."dw_company" IS 'DW_企业基本信息';

-- ----------------------------
-- Records of dw_company
-- ----------------------------
INSERT INTO "gas_ods"."dw_company" VALUES (4242357, NULL, '（I）4600283', NULL, ' 博厚金牌老地方海鲜店', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, '469028', '04', NULL, 'H', '6220', NULL, '海南省临高', NULL, '9600', NULL, '9600', '王琪', NULL, NULL, NULL, '5.0', NULL, NULL, NULL, NULL, NULL, '156', NULL, '13976932006', NULL, '海南省临高', '146000784.0', NULL, '2016-08-25', NULL, NULL, NULL, NULL, '2015-09-27', NULL, NULL, '2', NULL, NULL, '10', NULL, '2020-03-27 15:57:12', 'arpripinfo', 'null');

-- ----------------------------
-- Table structure for t_jcd_zj_haxgcp_car
-- ----------------------------
DROP TABLE IF EXISTS "gas_ods"."t_jcd_zj_haxgcp_car";
CREATE TABLE "gas_ods"."t_jcd_zj_haxgcp_car" (
  "shard_id" int8 NOT NULL DEFAULT nextval('"gas_ods".t_jcd_zj_haxgcp_car_shard_id_seq'::regclass),
  "lsxh" varchar(4000) NOT NULL,
  "datec" varchar(4000),
  "timec" varchar(4000),
  "prndate" varchar(4000),
  "cphm" varchar(4000),
  "cx" varchar(4000),
  "tpqk" varchar(4000),
  "persons" varchar(4000),
  "shipname" varchar(4000),
  "departdate" varchar(4000),
  "regularno" varchar(4000),
  "isdriver" varchar(4000),
  "userid" varchar(4000),
  "username" varchar(4000),
  "indate" varchar(4000),
  "tpqktime" varchar(4000),
  "tpqkname" varchar(4000),
  "updatetime" varchar(4000),
  "ods_rksj" varchar(4000),
  "ods_gxsj" varchar(4000),
  "jrsj" varchar(4000),
  "form_datec" numeric(32),
  "form_timec" numeric(32),
  "form_prndate" numeric(32),
  "form_departdate" numeric(32),
  "form_userid" varchar(4000),
  "form_indate" numeric(32),
  "form_tpqktime" numeric(32),
  "form_updatetime" numeric(32),
  "form_ods_rksj" numeric(32),
  "form_ods_gxsj" numeric(32),
  "form_jrsj" numeric(32),
  "tag_track_time" varchar(4000),
  "tag_householdreg" varchar(4000),
  "tag_birthdate" varchar(4000),
  "tag_sex" varchar(4000),
  "tag_hhreg_orgval" varchar(4000),
  "ws_rksj" varchar(14) DEFAULT to_char(now(), 'yyyymmddhh24miss'::text)
)
;
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."lsxh" IS '车单号';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."datec" IS '售票日期';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."timec" IS '售票时间';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."prndate" IS '打印时间';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."cphm" IS '车牌号码';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."cx" IS '车辆类型';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."tpqk" IS '退票标志';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."persons" IS '随车人数';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."shipname" IS '船名';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."departdate" IS '船出发日期';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."regularno" IS '航班号';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."isdriver" IS '是否包含司机';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."userid" IS '购票身份证';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."username" IS '购票姓名';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."indate" IS '入库时间';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."tpqktime" IS '退票时间';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."tpqkname" IS '退票人';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."updatetime" IS '更新时间';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."jrsj" IS '接入时间';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."form_datec" IS '售票日期';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."form_timec" IS '售票时间';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."form_prndate" IS '打印时间';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."form_departdate" IS '船出发日期';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."form_userid" IS '购票身份证';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."form_indate" IS '入库时间';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."form_tpqktime" IS '退票时间';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."form_updatetime" IS '更新时间';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."form_jrsj" IS '接入时间';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."tag_track_time" IS 'null';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."tag_householdreg" IS 'null';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."tag_birthdate" IS 'null';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."tag_sex" IS 'null';
COMMENT ON COLUMN "gas_ods"."t_jcd_zj_haxgcp_car"."tag_hhreg_orgval" IS 'null';
COMMENT ON TABLE "gas_ods"."t_jcd_zj_haxgcp_car" IS '进出岛-湛江海安新港车票数据（车票）';

-- ----------------------------
-- Records of t_jcd_zj_haxgcp_car
-- ----------------------------
INSERT INTO "gas_ods"."t_jcd_zj_haxgcp_car" VALUES (4, '191591028', '2019-01-28 00:00:00', '21:25:36', '2019-01-28 21:25:00', '津LCE444', '12座及以下小车', '正常票', '2', '双7', '2019-01-28 20:17:00', '043', '1', '460027198001273417', '何某某', '2019-01-28 21:26:57', NULL, NULL, '2019-01-28 21:25:36', '20190128212919', '20190128212919', '2019-01-29 21:59:56', 1548604800, 0, 1548681900, 1548677820, '4273417', 1548682017, NULL, 1548681936, 1548682159, 1548682159, 1548770396, '3', '46027', '1980', '1', '4600273417', '202005');
-- ----------------------------
-- Table structure for t_jj_hkddc
-- ----------------------------
DROP TABLE IF EXISTS "gas_ods"."t_jj_hkddc";
CREATE TABLE "gas_ods"."t_jj_hkddc" (
  "shard_id" int8 NOT NULL DEFAULT nextval('"gas_ods".t_jj_hkddc_shard_id_seq'::regclass),
  "xxzjbh" varchar(4000) NOT NULL,
  "hpzl" varchar(4000),
  "hphm" varchar(4000),
  "ddc_csys_ysdm" varchar(4000),
  "cz_xm" varchar(4000),
  "zjlb" varchar(4000),
  "djdw_gajgmc" varchar(4000),
  "ddc_djh" varchar(4000),
  "ddc_cjh" varchar(4000),
  "zzl" varchar(4000),
  "cz_gmsfzh" varchar(4000),
  "xxdz" varchar(4000),
  "cz_gddh" varchar(4000),
  "cz_lxdh" varchar(4000),
  "djsj" varchar(4000),
  "zt" varchar(4000),
  "djr_xm" varchar(4000),
  "ddc_ppxh" varchar(4000),
  "hgzh" varchar(4000),
  "sccj" varchar(4000),
  "scrq" varchar(4000),
  "yb" varchar(4000),
  "dlr" varchar(4000),
  "dlsfzh" varchar(4000),
  "dlrdh" varchar(4000),
  "ods_gxsj" varchar(4000),
  "jrsj" varchar(4000),
  "dlrdz" varchar(4000),
  "dlrsj" varchar(4000),
  "zzglbm" varchar(4000),
  "pzdate" varchar(4000),
  "rksj" varchar(4000),
  "cjdwdm" varchar(4000),
  "cjdwmc" varchar(4000),
  "cjrxm" varchar(4000),
  "cjsj" varchar(4000),
  "gxdwdm" varchar(4000),
  "gxdwmc" varchar(4000),
  "gxrxm" varchar(4000),
  "gxsj" varchar(4000),
  "ods_rksj" varchar(4000),
  "dic_hpzl" varchar(4000),
  "dic_ddc_csys_ysdm" varchar(4000),
  "dic_zjlb" varchar(4000),
  "form_cz_gmsfzh" varchar(4000),
  "form_cz_gddh" varchar(4000),
  "form_cz_lxdh" varchar(4000),
  "form_djsj" numeric(32),
  "form_scrq" numeric(32),
  "form_rksj" numeric(32),
  "form_cjsj" numeric(32),
  "form_ods_rksj" numeric(32),
  "form_ods_gxsj" numeric(32),
  "form_jrsj" numeric(32),
  "ws_rksj" varchar(14) NOT NULL DEFAULT to_char(now(), 'yyyymmddhh24miss'::text)
)
;
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."xxzjbh" IS '信息主键编号';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."hpzl" IS '号牌种类';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."hphm" IS '号牌号码';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."ddc_csys_ysdm" IS '车身颜色代码';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."cz_xm" IS '车主姓名';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."zjlb" IS '证件类别';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."djdw_gajgmc" IS '登记单位_公安机关名称';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."ddc_djh" IS '电机号码';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."ddc_cjh" IS '车架号码';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."zzl" IS '重量';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."cz_gmsfzh" IS '身份证号';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."xxdz" IS '登记地址';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."cz_gddh" IS '固定电话';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."cz_lxdh" IS '手机号码';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."djsj" IS '登记时间';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."zt" IS '状态';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."djr_xm" IS '登记人_姓名';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."ddc_ppxh" IS '车辆品牌';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."hgzh" IS '合格证号';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."sccj" IS '生产厂家';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."scrq" IS '生产日期';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."yb" IS '邮编';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."dlr" IS '代理人';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."dlsfzh" IS '代理人证号';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."dlrdh" IS '代理人电话';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."ods_gxsj" IS 'ods更新时间';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."jrsj" IS '接入时间';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."dlrdz" IS '代理人地址';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."dlrsj" IS '代理人手机';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."rksj" IS '抽取入库时间';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."cjdwdm" IS '创建单位代码';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."cjdwmc" IS '创建单位名称';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."cjrxm" IS '创建人姓名';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."cjsj" IS '创建时间';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."gxdwdm" IS '修改单位名称';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."gxdwmc" IS '修改单位代码';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."gxrxm" IS '修改人姓名';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."gxsj" IS '修改时间';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."ods_rksj" IS 'ods入库时间';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."dic_hpzl" IS '号牌种类  (字典)';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."dic_ddc_csys_ysdm" IS '车身颜色代码(字典)';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."dic_zjlb" IS '证件类别  (字典)';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."form_cz_gmsfzh" IS '身份证号';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."form_cz_gddh" IS '固定电话';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."form_cz_lxdh" IS '手机号码';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."form_djsj" IS '登记时间';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."form_scrq" IS '生产日期';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."form_rksj" IS '抽取入库时间';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."form_cjsj" IS '创建时间';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."form_ods_rksj" IS 'ods入库时间';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."form_ods_gxsj" IS 'ods更新时间';
COMMENT ON COLUMN "gas_ods"."t_jj_hkddc"."form_jrsj" IS '接入时间';
COMMENT ON TABLE "gas_ods"."t_jj_hkddc" IS '电动车实名制信息';

