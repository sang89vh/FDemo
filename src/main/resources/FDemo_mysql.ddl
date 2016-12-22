DROP TABLE IF EXISTS sys_user_role;
DROP TABLE IF EXISTS sys_user;
DROP TABLE IF EXISTS sys_para;
DROP TABLE IF EXISTS sys_menu;
DROP TABLE IF EXISTS sto_ref_site;
DROP TABLE IF EXISTS sto_investing;
DROP TABLE IF EXISTS sto_his_price;
DROP TABLE IF EXISTS sto_event_right;
DROP TABLE IF EXISTS sto_depen_idx;
DROP TABLE IF EXISTS sto_company;


CREATE TABLE sys_user_role (user_role_id bigint(19) NOT NULL AUTO_INCREMENT, user_id bigint(19) NOT NULL, user_name varchar(255), role varchar(255), PRIMARY KEY (user_role_id));
CREATE TABLE sys_user (user_id bigint(19) NOT NULL AUTO_INCREMENT, user_name varchar(255) NOT NULL, password varchar(255) NOT NULL, enabled tinyint(1) DEFAULT b'1', PRIMARY KEY (user_id));
CREATE TABLE sys_para (sys_para_id bigint(19) NOT NULL AUTO_INCREMENT, code varchar(255) NOT NULL, value text NOT NULL, `GROUP` varchar(255), PRIMARY KEY (sys_para_id));
CREATE TABLE sys_menu (menu_id bigint(19) NOT NULL AUTO_INCREMENT, title varchar(255), path varchar(255), url varchar(255), parent_id bigint(19), PRIMARY KEY (menu_id));
CREATE TABLE sto_ref_site (ref_site_id bigint(19) NOT NULL AUTO_INCREMENT, symbol varchar(255), url text, PRIMARY KEY (ref_site_id));
CREATE TABLE sto_investing (symbol varchar(255), investing_id bigint(19) NOT NULL AUTO_INCREMENT, reason_buy text, reason_sell text, expect_start_date date, expect_end_date date, actual_start_date date, actual_end_date date, count_day bigint(19), adjustment_price bigint(19), real_price bigint(19), safe_distance bigint(19), expect_buy_price bigint(19), expect_sell_price bigint(19), total_volume bigint(19), total_value bigint(19), actual_buy_price bigint(19), actual_sell_price bigint(19), devidend_stock bigint(19), devidend_penny bigint(19), sell_volume bigint(19), profit bigint(19), percent_profit bigint(19), expect_profit bigint(19), expect_percent_profit bigint(19), fee_exchange bigint(19), profit_per_day bigint(19), PRIMARY KEY (investing_id));
CREATE TABLE sto_his_price (his_price_id bigint(19) NOT NULL AUTO_INCREMENT, symbol varchar(255), trading_date date, open_price bigint(19), high_price bigint(19), low_price bigint(19), close_price bigint(19), volume bigint(19), market varchar(255), PRIMARY KEY (his_price_id));
CREATE TABLE sto_event_right (event_right_id bigint(19) NOT NULL AUTO_INCREMENT, symbol varchar(255), exchange varchar(255), event_type varchar(255), right_date date, register_date date, action_date date, content text, `PERCENT` int(10), current_price bigint(19), PRIMARY KEY (event_right_id));
CREATE TABLE sto_depen_idx (depen_idx_id bigint(19) NOT NULL AUTO_INCREMENT, symbol varchar(255), trading_date date, price bigint(19), PRIMARY KEY (depen_idx_id));
CREATE TABLE sto_company (company_id bigint(19) NOT NULL AUTO_INCREMENT, name text, total_years_activity bigint(19), point bigint(19), domain varchar(255), listed_date date, symbol varchar(255), status varchar(255), PRIMARY KEY (company_id));

CREATE TABLE sto_trade_log (trade_log_id bigint(19) NOT NULL AUTO_INCREMENT, trading_code varchar(255), buy_sell varchar(255), symbol varchar(255), volume bigint(19), value bigint(19), tax bigint(19), fee bigint(19), PRIMARY KEY (trade_log_id));

