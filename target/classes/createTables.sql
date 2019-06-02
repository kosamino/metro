DROP DATABASE IF EXISTS metro ;
CREATE DATABASE metro CHARACTER SET utf8 ;
USE metro ;

DROP TABLE IF EXISTS tb_passenger ;
CREATE TABLE tb_passenger (
    passenger_id         BIGINT NOT NULL AUTO_INCREMENT COMMENT '乘客ID',
    passenger_name       VARCHAR(50) NOT NULL COMMENT '姓名',
    passenger_sex        VARCHAR(1) CHECK (passenger_sex='M' or passenger_sex='F') COMMENT '性别',
    travel_card          BIGINT COMMENT '交通卡号',
    oneway_card          BIGINT COMMENT '单程卡号',
    CONSTRAINT pk_passenger_id PRIMARY KEY(passenger_id)
)ENGINE InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_metro_station ;
CREATE TABLE tb_metro_station (
    station_no           BIGINT NOT NULL AUTO_INCREMENT COMMENT '站点编号',
    station_name         VARCHAR(50) NOT NULL COMMENT '站点名',
    station_desc         VARCHAR(50) COMMENT '站点说明',
    CONSTRAINT pk_station_no PRIMARY KEY(station_no)
)ENGINE InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_metro_line ;
CREATE TABLE tb_metro_line (
    id                   BIGINT NOT NULL AUTO_INCREMENT,
    line_no              INT NOT NULL COMMENT '地铁线路',
    start_station        BIGINT NOT NULL COMMENT '开始站',
    end_station          BIGINT NOT NULL COMMENT '结束点',
    line_weight          INT  NOT NULL COMMENT '站点间价格',
    CONSTRAINT pk_id PRIMARY KEY(id),
    CONSTRAINT FOREIGN KEY (start_station) REFERENCES tb_metro_station(station_no),
    CONSTRAINT FOREIGN KEY (end_station) REFERENCES tb_metro_station(station_no)
)ENGINE InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_travel_card ;
CREATE TABLE tb_travel_card (
    travel_card_no       BIGINT NOT NULL AUTO_INCREMENT COMMENT '交通卡号',
    passenger_id         BIGINT NOT NULL COMMENT '乘客ID',
    remainder            BIGINT NOT NULL COMMENT '卡内余额',
    CONSTRAINT travel_card_no PRIMARY KEY(travel_card_no),
    CONSTRAINT FOREIGN KEY (passenger_id) REFERENCES tb_passenger(passenger_id)
)ENGINE InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_oneway_card ;
CREATE TABLE tb_oneway_card (
    oneway_card_no       BIGINT NOT NULL AUTO_INCREMENT COMMENT '单程卡号',
    passenger_id         BIGINT NOT NULL COMMENT '乘客ID',
    amount               BIGINT NOT NULL COMMENT '单程卡金额',
    usage_flag           INT NOT NULL CHECK (usage_flag=0 or usage_flag=1)  DEFAULT 0 COMMENT '0,有效;1,无效',
    purchase_time        DATE NOT NULL COMMENT '购买日期',
    expire_time          DATE NOT NULL COMMENT '失效日期',
    CONSTRAINT pk_oneway_card_no PRIMARY KEY(oneway_card_no),
    CONSTRAINT FOREIGN KEY (passenger_id) REFERENCES tb_passenger(passenger_id)
)ENGINE InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_travel_record ;
CREATE TABLE tb_travel_record (
    travel_record_id     BIGINT NOT NULL AUTO_INCREMENT COMMENT '出行记录ID',
    passenger_id         BIGINT NOT NULL COMMENT '乘客ID',
    begin_station_id     BIGINT NOT NULL COMMENT '起点站ID',
    final_station_id     BIGINT NOT NULL COMMENT '终点站ID',
    amount               BIGINT NOT NULL COMMENT '行程价格',
    travel_card          BIGINT COMMENT '交通卡号',
    oneway_card          BIGINT COMMENT '单程卡号',
    travel_info          VARCHAR(500) NOT NULL COMMENT '行程详情',
    occur_time           DATE NOT NULL COMMENT '发生时间',
    CONSTRAINT pk_travel_record_id PRIMARY KEY(travel_record_id),
    CONSTRAINT FOREIGN KEY (begin_station_id) REFERENCES tb_metro_station(station_no),
    CONSTRAINT FOREIGN KEY (final_station_id) REFERENCES tb_metro_station(station_no)
)ENGINE InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_fees_record ;
CREATE TABLE tb_fees_record (
    fees_id              BIGINT NOT NULL AUTO_INCREMENT COMMENT '交通卡费用记录ID',
    travel_card          BIGINT NOT NULL COMMENT '交通卡号',
    operation_type       INT NOT NULL CHECK (operation_type=0 or operation_type=1) COMMENT '0,充值;1,消费',
    mount                BIGINT NOT NULL COMMENT '金额',
    occur_time           DATE NOT NULL COMMENT '发生时间',
    CONSTRAINT pk_fees_id PRIMARY KEY(fees_id),
    CONSTRAINT FOREIGN KEY (travel_card) REFERENCES tb_travel_card(travel_card_no)
)ENGINE InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_black_list ;
CREATE TABLE tb_black_list (
    black_record_id      BIGINT NOT NULL AUTO_INCREMENT COMMENT '黑名单记录ID',
    passenger_id         BIGINT NOT NULL COMMENT '乘客ID',
    travel_record_id     BIGINT NOT NULL COMMENT '出行记录ID',
    occur_time           DATE NOT NULL COMMENT '发生时间',
    CONSTRAINT pk_black_record_id PRIMARY KEY(black_record_id),
    CONSTRAINT FOREIGN KEY (passenger_id) REFERENCES tb_passenger(passenger_id),
    CONSTRAINT FOREIGN KEY (travel_record_id) REFERENCES tb_travel_record(travel_record_id)
)ENGINE InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS tb_route_plan ;
CREATE TABLE tb_route_plan (
    route_id     BIGINT NOT NULL AUTO_INCREMENT COMMENT 'ID',
    begin_station_id     BIGINT NOT NULL COMMENT '起点站ID',
    begin_station_name   VARCHAR(50) NOT NULL COMMENT '起点站名称',
    final_station_id     BIGINT NOT NULL COMMENT '终点站ID',
    final_station_name   VARCHAR(50) NOT NULL COMMENT '终点站名称',
    amount               BIGINT NOT NULL COMMENT '行程价格',
    route_plan          VARCHAR(2000) NOT NULL COMMENT '乘坐路线详情',
    CONSTRAINT pk_route_id PRIMARY KEY(route_id),
    CONSTRAINT FOREIGN KEY (begin_station_id) REFERENCES tb_metro_station(station_no),
    CONSTRAINT FOREIGN KEY (final_station_id) REFERENCES tb_metro_station(station_no)
)ENGINE InnoDB DEFAULT CHARSET=utf8;