prompt PL/SQL Developer import file
prompt Created on 2029年7月6日 by Administrator
set feedback off
set define off
prompt Dropping RPT_05_AY...
drop table RPT_05_AY cascade constraints;
prompt Dropping RPT_100103_TYPE...
drop table RPT_100103_TYPE cascade constraints;
prompt Dropping RPT_100201_TYPE...
drop table RPT_CHECK_COLUMN cascade constraints;
prompt Dropping RPT_CHECK_FAIL...
drop table RPT_CHECK_FAIL cascade constraints;
prompt Dropping RPT_CHECK_ROW...
drop table RPT_CHECK_ROW cascade constraints;
prompt Dropping RPT_CHECK_SUCCESS...
drop table RPT_CHECK_SUCCESS cascade constraints;
prompt Dropping RPT_GXAJ...
drop table RPT_GXAJ cascade constraints;
prompt Creating RPT_05_AY...
create table RPT_05_AY
(
  dm      VARCHAR2(10),
  ay      VARCHAR2(128),
  orderid NUMBER(3)
)
;
comment on table RPT_05_AY
  is '报表案由统计';
comment on column RPT_05_AY.dm
  is '赔偿案由代码';
comment on column RPT_05_AY.ay
  is '赔偿案由名称';
comment on column RPT_05_AY.orderid
  is '排序号';

prompt Creating RPT_100103_TYPE...
create table RPT_100103_TYPE
(
  id        VARCHAR2(20),
  mc        VARCHAR2(512),
  orderid   NUMBER(2),
  isdisplay NUMBER(2)
)
;
comment on column RPT_100103_TYPE.id
  is 'id来自于';
comment on column RPT_100103_TYPE.mc
  is '名称来自于';
comment on column RPT_100103_TYPE.orderid
  is '排序号';
comment on column RPT_100103_TYPE.isdisplay
  is '是否显示，0不显示，1显示';

prompt Creating RPT_100201_TYPE...
create table RPT_100201_TYPE
(
  id      VARCHAR2(20),
  mc      VARCHAR2(512),
  orderid NUMBER(2)
)
;
comment on table RPT_100201_TYPE
  is '执行异议案件统计表--类型';
comment on column RPT_100201_TYPE.id
  is 'id来自于';
comment on column RPT_100201_TYPE.mc
  is '名称来自于';
comment on column RPT_100201_TYPE.orderid
  is '排序号';

prompt Creating RPT_100202_TYPE...
create table RPT_100202_TYPE
(
  id      VARCHAR2(20),
  mc      VARCHAR2(512),
  orderid NUMBER(2)
)
;
comment on table RPT_100202_TYPE
  is '执行复议案件统计表--类型';
comment on column RPT_100202_TYPE.id
  is 'id来自于';
comment on column RPT_100202_TYPE.mc
  is '名称来自于';
comment on column RPT_100202_TYPE.orderid
  is '排序号';

prompt Creating RPT_100203_TYPE...
create table RPT_100203_TYPE
(
  id      VARCHAR2(20),
  mc      VARCHAR2(512),
  orderid NUMBER(2)
)
;
comment on table RPT_100203_TYPE
  is '执行监督案件统计表--类型';
comment on column RPT_100203_TYPE.id
  is 'id来自于';
comment on column RPT_100203_TYPE.mc
  is '名称来自于';
comment on column RPT_100203_TYPE.orderid
  is '排序号';

prompt Creating RPT_100204_TYPE...
create table RPT_100204_TYPE
(
  id      VARCHAR2(20),
  mc      VARCHAR2(512),
  orderid NUMBER(2)
)
;
comment on table RPT_100204_TYPE
  is '执行协调案件统计表--类型';
comment on column RPT_100204_TYPE.id
  is 'id来自于';
comment on column RPT_100204_TYPE.mc
  is '名称来自于';
comment on column RPT_100204_TYPE.orderid
  is '排序号';

prompt Creating RPT_100300_TYPE...
create table RPT_100300_TYPE
(
  id      VARCHAR2(20),
  mc      VARCHAR2(512),
  orderid NUMBER
)
;
comment on table RPT_100300_TYPE
  is '其他执行案件统计表--类型';
comment on column RPT_100300_TYPE.id
  is 'id来自于';
comment on column RPT_100300_TYPE.mc
  is '名称来自于';
comment on column RPT_100300_TYPE.orderid
  is '排序号';

prompt Creating RPT_110002_TYPE...
create table RPT_110002_TYPE
(
  spcx      VARCHAR2(16) not null,
  bigtype   VARCHAR2(32) not null,
  smalltype VARCHAR2(32),
  px        NUMBER(2),
  spcx_old  VARCHAR2(600)
)
;

prompt Creating RPT_110003_AY...
create table RPT_110003_AY
(
  dm VARCHAR2(10),
  mc VARCHAR2(32),
  px NUMBER(3)
)
;
comment on table RPT_110003_AY
  is '显示罪名';
comment on column RPT_110003_AY.dm
  is '案由代码';
comment on column RPT_110003_AY.mc
  is '案由名称';
comment on column RPT_110003_AY.px
  is '序号';

prompt Creating RPT_AJLB...
create table RPT_AJLB
(
  dm  NUMBER,
  mc  VARCHAR2(512),
  pdm NUMBER,
  pmc VARCHAR2(50)
)
;
comment on table RPT_AJLB
  is '案件类别';
comment on column RPT_AJLB.dm
  is '代码';
comment on column RPT_AJLB.mc
  is '名称';
comment on column RPT_AJLB.pdm
  is '父代码';
comment on column RPT_AJLB.pmc
  is '父名称';

prompt Creating RPT_AJLX...
create table RPT_AJLX
(
  id   VARCHAR2(20),
  mlbh VARCHAR2(10),
  dm   VARCHAR2(10),
  fdm  VARCHAR2(10),
  fjm  VARCHAR2(20),
  mc   VARCHAR2(512)
)
;
comment on table RPT_AJLX
  is '案件类型';

prompt Creating RPT_AY...
create table RPT_AY
(
  dm      VARCHAR2(10) not null,
  ay0     VARCHAR2(32),
  ay1     VARCHAR2(64),
  ay2     VARCHAR2(64),
  ay3     VARCHAR2(80),
  ay4     VARCHAR2(100),
  xh      NUMBER(6),
  aylevel NUMBER(6)
)
;
comment on table RPT_AY
  is '报表案由统计';
comment on column RPT_AY.dm
  is '案由代码';
comment on column RPT_AY.ay0
  is '案由名称0级';
comment on column RPT_AY.ay1
  is '案由名称1级';
comment on column RPT_AY.ay2
  is '案由名称2级';
comment on column RPT_AY.ay3
  is '案由名称3级';
comment on column RPT_AY.ay4
  is '案由名称4级';
comment on column RPT_AY.xh
  is '排序号';
comment on column RPT_AY.aylevel
  is '层级';

prompt Creating RPT_CASE...
create table RPT_CASE
(
  cnid          NUMBER(38) not null,
  case_title    VARCHAR2(60),
  case_category VARCHAR2(20),
  px            NUMBER(2),
  gb1_display   VARCHAR2(2)
)
;
comment on table RPT_CASE
  is '统计表中把表号案名关联';
comment on column RPT_CASE.cnid
  is 'CNID';
comment on column RPT_CASE.case_title
  is '统计表名称';
comment on column RPT_CASE.case_category
  is '案件类别';
comment on column RPT_CASE.px
  is '排序号';
comment on column RPT_CASE.gb1_display
  is '公报1显示项目(Y显示,N不显示)';

prompt Creating RPT_CHECK_FAIL...
create table RPT_CHECK_FAIL
(
  report_id VARCHAR2(32),
  rule      VARCHAR2(128),
  data      VARCHAR2(256),
  checkdate DATE,
  url       VARCHAR2(256),
  rowno     NUMBER(6),
  colno     NUMBER(6)
)
;
comment on table RPT_CHECK_FAIL
  is '核对失败记录';
comment on column RPT_CHECK_FAIL.report_id
  is '报表代号';
comment on column RPT_CHECK_FAIL.rule
  is '规则';
comment on column RPT_CHECK_FAIL.data
  is '实际核对式';
comment on column RPT_CHECK_FAIL.checkdate
  is '核对时间';
comment on column RPT_CHECK_FAIL.url
  is 'URL';
comment on column RPT_CHECK_FAIL.rowno
  is '出错的行号';
comment on column RPT_CHECK_FAIL.colno
  is '出错的列号';

prompt Creating RPT_CHECK_ROW...
create table RPT_CHECK_ROW
(
  report_id    VARCHAR2(32) not null,
  remark       VARCHAR2(128) not null,
  rule         VARCHAR2(128) not null,
  start_row    NUMBER(2),
  end_row      NUMBER(2),
  rulepara     VARCHAR2(128),
  start_column NUMBER(2) default 0
)
;
comment on table RPT_CHECK_ROW
  is '横向核验规则';
comment on column RPT_CHECK_ROW.report_id
  is '报表代号';
comment on column RPT_CHECK_ROW.remark
  is '左上角的横向描述';
comment on column RPT_CHECK_ROW.rule
  is '规则';
comment on column RPT_CHECK_ROW.start_row
  is '开始列';
comment on column RPT_CHECK_ROW.end_row
  is '结束列';
comment on column RPT_CHECK_ROW.rulepara
  is '规则变换参数表达式';
comment on column RPT_CHECK_ROW.start_column
  is '开始取数的行';

prompt Creating RPT_CHECK_SUCCESS...
create table RPT_CHECK_SUCCESS
(
  report_id  VARCHAR2(32),
  checkdate  DATE,
  url        VARCHAR2(256),
  fycode     VARCHAR2(20),
  isby       VARCHAR2(2),
  startmonth VARCHAR2(12),
  endmonth   VARCHAR2(12)
)
;
comment on table RPT_CHECK_SUCCESS
  is '核对成功记录';
comment on column RPT_CHECK_SUCCESS.report_id
  is '报表代号';
comment on column RPT_CHECK_SUCCESS.checkdate
  is '核对时间';
comment on column RPT_CHECK_SUCCESS.url
  is 'URL';
comment on column RPT_CHECK_SUCCESS.fycode
  is '法院号';
comment on column RPT_CHECK_SUCCESS.isby
  is '是否本院';
comment on column RPT_CHECK_SUCCESS.startmonth
  is '开始月份';
comment on column RPT_CHECK_SUCCESS.endmonth
  is '结束月份';

prompt Creating RPT_GXAJ...
create table RPT_GXAJ
(
  id   VARCHAR2(20),
  dm   VARCHAR2(10),
  fdm  VARCHAR2(10),
  mc   VARCHAR2(512),
  ajmc VARCHAR2(1010),
  xh   NUMBER
)
;

prompt Disabling triggers for RPT_05_AY...
alter table RPT_05_AY disable all triggers;
prompt Disabling triggers for RPT_100103_TYPE...
alter table RPT_100103_TYPE disable all triggers;
prompt Disabling triggers for RPT_100201_TYPE...
alter table RPT_100201_TYPE disable all triggers;
prompt Disabling triggers for RPT_100202_TYPE...
alter table RPT_100202_TYPE disable all triggers;
prompt Disabling triggers for RPT_100203_TYPE...
alter table RPT_100203_TYPE disable all triggers;
prompt Disabling triggers for RPT_100204_TYPE...
alter table RPT_100204_TYPE disable all triggers;
prompt Disabling triggers for RPT_100300_TYPE...
alter table RPT_100300_TYPE disable all triggers;
prompt Disabling triggers for RPT_110002_TYPE...
alter table RPT_110002_TYPE disable all triggers;
prompt Disabling triggers for RPT_110003_AY...
alter table RPT_110003_AY disable all triggers;
prompt Disabling triggers for RPT_AJLB...
alter table RPT_AJLB disable all triggers;
prompt Disabling triggers for RPT_AJLX...
alter table RPT_AJLX disable all triggers;
prompt Disabling triggers for RPT_AY...
alter table RPT_AY disable all triggers;
prompt Disabling triggers for RPT_CASE...
alter table RPT_CASE disable all triggers;
prompt Disabling triggers for RPT_CHECK_COLUMN...
alter table RPT_CHECK_COLUMN disable all triggers;
prompt Disabling triggers for RPT_CHECK_FAIL...
alter table RPT_CHECK_FAIL disable all triggers;
prompt Disabling triggers for RPT_CHECK_ROW...
alter table RPT_CHECK_ROW disable all triggers;
prompt Disabling triggers for RPT_CHECK_SUCCESS...
alter table RPT_CHECK_SUCCESS disable all triggers;
prompt Disabling triggers for RPT_GXAJ...
alter table RPT_GXAJ disable all triggers;
prompt Loading RPT_05_AY...
insert into RPT_05_AY (dm, ay, orderid)
values ('2102', '违法刑事拘留赔偿', 2);
insert into RPT_05_AY (dm, ay, orderid)
values ('2105', '二审无罪赔偿', 4);
insert into RPT_05_AY (dm, ay, orderid)
values ('2106', '重审无罪赔偿', 5);
insert into RPT_05_AY (dm, ay, orderid)
values ('2107', '再审无罪赔偿', 6);
insert into RPT_05_AY (dm, ay, orderid)
values ('2108', '刑讯逼供致伤、致死赔偿', 7);
insert into RPT_05_AY (dm, ay, orderid)
values ('2109', '殴打、虐待或唆使他人以殴打、虐待等行为致伤、致死赔偿', 8);
insert into RPT_05_AY (dm, ay, orderid)
values ('2110', '违法使用武器、警械致伤、致死赔偿', 9);
insert into RPT_05_AY (dm, ay, orderid)
values ('2111', '刑事违法查封、扣押、冻结、追缴赔偿', 10);
insert into RPT_05_AY (dm, ay, orderid)
values ('2112', '错判罚金、没收财产赔偿', 11);
insert into RPT_05_AY (dm, ay, orderid)
values ('2115', '违法司法拘留赔偿', 13);
insert into RPT_05_AY (dm, ay, orderid)
values ('2116', '违法保全赔偿', 14);
insert into RPT_05_AY (dm, ay, orderid)
values ('2117', '错误执行赔偿', 15);
insert into RPT_05_AY (dm, ay, orderid)
values ('2104', '无罪逮捕赔偿', 3);
insert into RPT_05_AY (dm, ay, orderid)
values ('2114', '违法司法罚款赔偿', 12);
commit;
prompt 14 records loaded
prompt Loading RPT_100103_TYPE...
insert into RPT_100103_TYPE (id, mc, orderid, isdisplay)
values ('0501030', '其他', 8, 0);
insert into RPT_100103_TYPE (id, mc, orderid, isdisplay)
values ('050106', '解除诉中财产保全裁定', 7, 1);
insert into RPT_100103_TYPE (id, mc, orderid, isdisplay)
values ('050105', '诉中财产保全的担保财产保全裁定', 6, 1);
insert into RPT_100103_TYPE (id, mc, orderid, isdisplay)
values ('050104', '诉中财产保全裁定', 5, 1);
insert into RPT_100103_TYPE (id, mc, orderid, isdisplay)
values ('050103', '解除非诉财产保全裁定', 4, 1);
insert into RPT_100103_TYPE (id, mc, orderid, isdisplay)
values ('050102', '非诉财产保全的担保财产保全裁定', 3, 1);
insert into RPT_100103_TYPE (id, mc, orderid, isdisplay)
values ('050101', '非诉财产保全裁定', 2, 1);
commit;
prompt 7 records loaded
prompt Loading RPT_100201_TYPE...
insert into RPT_100201_TYPE (id, mc, orderid)
values ('050141', '执行行为异议', 2);
insert into RPT_100201_TYPE (id, mc, orderid)
values ('050142', '案外人异议', 3);
insert into RPT_100201_TYPE (id, mc, orderid)
values ('050143', '执行管辖权异议', 5);
insert into RPT_100201_TYPE (id, mc, orderid)
values ('050144', '申请追加、变更被执行人', 6);
insert into RPT_100201_TYPE (id, mc, orderid)
values ('050146', '被执行人以债权消灭、超过申请执行期间或者其他阻止执行的实体事由提出阻止执行', 10);
insert into RPT_100201_TYPE (id, mc, orderid)
values ('050148', '被执行人对公证机关赋予强制执行效力的公证债权文书提出不予执行申请', 9);
insert into RPT_100201_TYPE (id, mc, orderid)
values ('050145', '申请变更申请执行人', 7);
insert into RPT_100201_TYPE (id, mc, orderid)
values ('050147', '被执行人对仲裁裁决提出不予执行申请', 8);
insert into RPT_100201_TYPE (id, mc, orderid)
values ('0501430', '其他依法可以申请执行异议', 4);
commit;
prompt 9 records loaded
prompt Loading RPT_100202_TYPE...
insert into RPT_100202_TYPE (id, mc, orderid)
values ('054531', '不服执行行为异议裁定', 2);
insert into RPT_100202_TYPE (id, mc, orderid)
values ('054532', '不服追加、变更当事人裁定', 11);
insert into RPT_100202_TYPE (id, mc, orderid)
values ('054533', '不服执行管辖权异议裁定', 5);
insert into RPT_100202_TYPE (id, mc, orderid)
values ('054534', '不服不予执行裁定', 12);
insert into RPT_100202_TYPE (id, mc, orderid)
values ('054535', '不服驳回不予执行裁定', 7);
insert into RPT_100202_TYPE (id, mc, orderid)
values ('054536', '不服上级法院监督意见', 8);
insert into RPT_100202_TYPE (id, mc, orderid)
values ('054537', '不服对执行异议的不予受理或驳回申请裁定', 9);
insert into RPT_100202_TYPE (id, mc, orderid)
values ('054538', '不服采取的限制出境措施', 10);
insert into RPT_100202_TYPE (id, mc, orderid)
values ('0545330', '其他属于复议事项的案件', 6);
insert into RPT_100202_TYPE (id, mc, orderid)
values ('054539', '不服执行拘留决定', 3);
insert into RPT_100202_TYPE (id, mc, orderid)
values ('054540', '不服驳回不予执行公证债权文书裁定', 4);
insert into RPT_100202_TYPE (id, mc, orderid)
values ('054541', '不服执行罚款决定', 13);
commit;
prompt 12 records loaded
prompt Loading RPT_100203_TYPE...
insert into RPT_100203_TYPE (id, mc, orderid)
values ('055031', '下级法院应当依法作出不予执行裁定而不制作', 2);
insert into RPT_100203_TYPE (id, mc, orderid)
values ('055032', '下级法院在规定期限内未能执行结案，应当作出裁定、决定、通知而不制作', 3);
insert into RPT_100203_TYPE (id, mc, orderid)
values ('055033', '下级法院在规定期限内未能执行结案，应当依法实施具体执行行为而不实施', 5);
insert into RPT_100203_TYPE (id, mc, orderid)
values ('055034', '执行行为不当或错误', 6);
insert into RPT_100203_TYPE (id, mc, orderid)
values ('055035', '有可供执行财产或有条件执行的案件超六个月未执行完结', 7);
insert into RPT_100203_TYPE (id, mc, orderid)
values ('055036', '对法律文书确定的行为义务超六个月未依法采取相应执行措施', 8);
insert into RPT_100203_TYPE (id, mc, orderid)
values ('055037', '在上级法院责令限期执行期间内无正当理由仍未执行完结', 9);
insert into RPT_100203_TYPE (id, mc, orderid)
values ('055038', '下级法院长期未能执结', 10);
insert into RPT_100203_TYPE (id, mc, orderid)
values ('055039', '在上级法院责令限期纠正期间内无正当理由未予纠正', 11);
insert into RPT_100203_TYPE (id, mc, orderid)
values ('0550330', '其他应当予以监督的情形', 4);
commit;
prompt 10 records loaded
prompt Loading RPT_100204_TYPE...
insert into RPT_100204_TYPE (id, mc, orderid)
values ('055531', '下级法院之间不同执行案件发生争议', 2);
insert into RPT_100204_TYPE (id, mc, orderid)
values ('055535', '法院与公安、检察等机关之间的执行争议', 10);
insert into RPT_100204_TYPE (id, mc, orderid)
values ('055538', '下级法院在执行中发现两地法院或与仲裁机构就同一法律关系作出不同裁判内容的法律文书', 13);
insert into RPT_100204_TYPE (id, mc, orderid)
values ('0555310', '法院与相关政府执法部门之间的执行争议', 3);
insert into RPT_100204_TYPE (id, mc, orderid)
values ('0555312', '执行协助部门因两地法院之间的执行冲突发生的争议', 5);
insert into RPT_100204_TYPE (id, mc, orderid)
values ('0555330', '其他需要协调处理的事项', 7);
insert into RPT_100204_TYPE (id, mc, orderid)
values ('0555311', '法院与商业银行等金融机构之间的执行争议', 4);
insert into RPT_100204_TYPE (id, mc, orderid)
values ('055532', '执行与破产之间对执行标的的争议', 6);
insert into RPT_100204_TYPE (id, mc, orderid)
values ('055533', '执行与强制清算之间对执行标的的争议', 8);
insert into RPT_100204_TYPE (id, mc, orderid)
values (null, '执行与审判程序之间对执行标的争议', 9);
insert into RPT_100204_TYPE (id, mc, orderid)
values ('055536', '受理内地仲裁机构涉港澳仲裁裁决执行申请的下级法院对其他下级法院拟撤销或不予撤销该裁决裁定存在异议', 11);
insert into RPT_100204_TYPE (id, mc, orderid)
values ('055537', '受理申请撤销内地仲裁机构涉港澳仲裁裁决的下级法院拟撤销其他下级法院已裁定予以执行的该项裁决', 12);
insert into RPT_100204_TYPE (id, mc, orderid)
values ('059521', '管辖权争议报请指定', 14);
commit;
prompt 13 records loaded
prompt Loading RPT_100300_TYPE...
insert into RPT_100300_TYPE (id, mc, orderid)
values ('059521', '管辖权争议报请指定', 2);
insert into RPT_100300_TYPE (id, mc, orderid)
values ('059523', '拟不予执行内地仲裁机构的涉外仲裁裁决', 3);
insert into RPT_100300_TYPE (id, mc, orderid)
values ('059524', '拟不予执行内地仲裁机构的涉港仲裁裁决', 5);
insert into RPT_100300_TYPE (id, mc, orderid)
values ('059525', '拟不予执行内地仲裁机构的涉澳仲裁裁决', 6);
insert into RPT_100300_TYPE (id, mc, orderid)
values ('059526', '拟中止执行上级人民法院的法律文书', 7);
insert into RPT_100300_TYPE (id, mc, orderid)
values ('059527', '拟停止或继续执行上级人民法院保全的财产', 8);
insert into RPT_100300_TYPE (id, mc, orderid)
values ('059528', '委托执行退回', 9);
insert into RPT_100300_TYPE (id, mc, orderid)
values ('059529', '因特殊情况需要上级法院执行而报请', 10);
insert into RPT_100300_TYPE (id, mc, orderid)
values ('0595210', '具体适用法律问题的请示', 11);
insert into RPT_100300_TYPE (id, mc, orderid)
values (null, '其他事项', 4);
commit;
prompt 10 records loaded
prompt Loading RPT_110002_TYPE...
prompt 2940 records loaded
prompt Loading RPT_GXAJ...
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('3000085', '85', '84', '提级管辖', '行政提级管辖案件', 5);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('3000037', '37', '36', '提级管辖', '民事提级管辖案件', 4);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('300003', '3', '2', '提级管辖', '刑事提级管辖案件', 3);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('30000112', '112', '111', '提级管辖', '行政赔偿提级管辖案件', 6);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('3000086', '86', '84', '指定管辖', '行政指定管辖案件', 10);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('3000038', '38', '36', '指定管辖', '民事指定管辖案件', 9);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('300004', '4', '2', '指定管辖', '刑事指定管辖案件', 8);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('30000113', '113', '111', '指定管辖', '行政赔偿指定管辖案件', 11);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('3000041', '41', '36', '管辖上诉', '民事管辖上诉案件', 13);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('3000087', '87', '84', '管辖上诉', '行政管辖上诉案件', 14);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('30000115', '115', '111', '管辖上诉', '行政赔偿管辖上诉案件', 15);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('3000039', '39', '36', '移交管辖审批', '民事移交管辖审批案件', 16);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('3000040', '40', '36', '协商管辖', '民事管辖协商案件', 18);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('30000114', '114', '111', '协商管辖', '行政赔偿管辖协商案件', 19);
insert into RPT_GXAJ (id, dm, fdm, mc, ajmc, xh)
values ('3000042', '42', '36', '管辖监督', '民事管辖监督案件', 20);
commit;
prompt 15 records loaded
prompt Enabling triggers for RPT_05_AY...
alter table RPT_05_AY enable all triggers;
prompt Enabling triggers for RPT_100103_TYPE...
alter table RPT_100103_TYPE enable all triggers;
prompt Enabling triggers for RPT_100201_TYPE...
alter table RPT_100201_TYPE enable all triggers;
prompt Enabling triggers for RPT_100202_TYPE...
alter table RPT_100202_TYPE enable all triggers;
prompt Enabling triggers for RPT_100203_TYPE...
alter table RPT_100203_TYPE enable all triggers;
prompt Enabling triggers for RPT_100204_TYPE...
alter table RPT_100204_TYPE enable all triggers;
prompt Enabling triggers for RPT_100300_TYPE...
alter table RPT_100300_TYPE enable all triggers;
prompt Enabling triggers for RPT_110002_TYPE...
alter table RPT_110002_TYPE enable all triggers;
prompt Enabling triggers for RPT_110003_AY...
alter table RPT_110003_AY enable all triggers;
prompt Enabling triggers for RPT_AJLB...
alter table RPT_AJLB enable all triggers;
prompt Enabling triggers for RPT_AJLX...
alter table RPT_AJLX enable all triggers;
prompt Enabling triggers for RPT_AY...
alter table RPT_AY enable all triggers;
prompt Enabling triggers for RPT_CASE...
alter table RPT_CASE enable all triggers;
prompt Enabling triggers for RPT_CHECK_COLUMN...
alter table RPT_CHECK_COLUMN enable all triggers;
prompt Enabling triggers for RPT_CHECK_FAIL...
alter table RPT_CHECK_FAIL enable all triggers;
prompt Enabling triggers for RPT_CHECK_ROW...
alter table RPT_CHECK_ROW enable all triggers;
prompt Enabling triggers for RPT_CHECK_SUCCESS...
alter table RPT_CHECK_SUCCESS enable all triggers;
prompt Enabling triggers for RPT_GXAJ...
alter table RPT_GXAJ enable all triggers;
set feedback on
set define on
prompt Done.
