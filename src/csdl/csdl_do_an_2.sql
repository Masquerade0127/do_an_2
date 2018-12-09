create database do_an_2;
use do_an_2;
create table hoc_vien
(
	ma_hv int(3) not null primary key auto_increment,
    ten_hv nvarchar(30) not null,
    ngay_sinh date not null,
    dien_thoai char(13) not null,
    email char(255) not null,
    dia_chi nvarchar(100) not null
);
create table giang_vien
(
	ma_gv int(3) not null primary key auto_increment,
    ten_gv nvarchar(30) not null,
    ngay_sinh date not null,
    dien_thoai char(13) not null,
    email char(255) not null,
    dia_chi nvarchar(100) not null
);
create table tai_khoan_hv
(
	ten_tai_khoan int(3) not null auto_increment,
    mat_khau char(255) not null,
    foreign key (ten_tai_khoan) references hoc_vien(ma_hv)
);
create table tai_khoan_gv
(
	ten_tai_khoan int(3) not null auto_increment,
    mat_khau char(255) not null,
    foreign key (ten_tai_khoan) references giang_vien(ma_gv)
);
create table tai_khoan_nv
(
	ten_tai_khoan int(3) not null primary key auto_increment,
    mat_khau char(255) not null
);
create table lop
(
	ma_lop char(10) not null primary key,
    ten_lop nvarchar(15) not null
);
create table phong
(
	ma_phong char(5) not null primary key,
    ten_phong nvarchar(20) not null
);
create table khoa_hoc
(
	ma_khoa_hoc char(5) not null primary key,
    ten_khoa_hoc nvarchar(15) not null
);
create table lich_hoc
( 
	ma_hv int(3) not null,
    ma_gv int(3) not null,
    ma_lop char(10) not null,
    ma_phong char(5) not null,
    foreign key (ma_hv) references hoc_vien(ma_hv),
	foreign key (ma_gv) references giang_vien(ma_gv),
	foreign key (ma_lop) references lop(ma_lop),
	foreign key (ma_phong) references phong(ma_phong)
);
create table lich_day
(
	ma_gv int(3) not null,
    ma_lop char(10) not null,
    ma_phong char(5) not null,
    foreign key (ma_gv) references giang_vien(ma_gv),
    foreign key (ma_lop) references lop(ma_lop),
    foreign key (ma_phong) references phong(ma_phong)
);
create table lich_thi
(
	ma_hv int(3) not null,
    ma_phong char(5) not null,
    ma_lop char(5) not null,
    foreign key (ma_hv) references hoc_vien(ma_hv),
	foreign key (ma_lop) references lop(ma_lop),
	foreign key (ma_phong) references phong(ma_phong)
);
create table bai_thi
(
	ma_bai_thi int(5) not null primary key auto_increment,
    ma_hv int(3) not null,
    diem int(2) not null,
    foreign key (ma_hv) references hoc_vien(ma_hv)
);
/*==== set auto increment ====*/
alter table tai_khoan_hv auto_increment = 100;
alter table tai_khoan_gv auto_increment = 100;
alter table tai_khoan_nv auto_increment = 10;
alter table hoc_vien auto_increment = 100;
alter table giang_vien auto_increment = 100;
alter table bai_thi auto_increment = 10000;

/*==== insert hoc_vien ====*/
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Le  Hai Trieu','1997-02-20','01652323040','trieu@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Le  Hai ','1997-05-26','01652323666','trieu@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Le Trieu','1996-02-20','01652323040','trieu@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Đặng Vui','1997-01-20','0919863497','vui@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Vui','1997-05-26','0919863497','vui@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Mộng Vui','1996-02-20','0919863497','vui@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('James Morrison','1996-02-20','0918360150','trieu@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('James','1997-01-20','01273417989','vui@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Morrison','1997-05-26','01273417989','vui@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Hannibal','1996-02-20','01273417989','vui@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Thai','1997-02-20','01273417989','thai@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Hoang','1998-02-21','0123645789','hoang@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Tri','1999-02-27','0123122900','tri@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Quoc','1993-05-20','09493417989','quoc@gmail.com','389 nguyen van cu can tho');
insert into hoc_vien(ten_hv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Nguyet','1996-01-10','0949863497','thai@gmail.com','389 nguyen van cu can tho');

/*==== insert giang_vien ====*/
insert into giang_vien(ten_gv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Parker','1986-02-20','01652323040','parker@gmail.com','389 nguyen van cu can tho');
insert into giang_vien(ten_gv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Panda','1970-05-24','01652323040','panda@gmail.com','389 nguyen van cu can tho');
insert into giang_vien(ten_gv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Lady duck duck','1992-09-30','01652323040','duck@gmail.com','389 nguyen van cu can tho');
insert into giang_vien(ten_gv, ngay_sinh, dien_thoai, email, dia_chi)
values ('Holmes','1991-03-29','01652323040','holmes@gmail.com','389 nguyen van cu can tho');
insert into giang_vien(ten_gv, ngay_sinh, dien_thoai, email, dia_chi)
values ('yukito','1987-05-03','01652323040','yukito@gmail.com','389 nguyen van cu can tho');

/*==== insert tai_khoan_hv ====*/
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('123456789');
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('987654321');
insert into tai_khoan_hv(mat_khau)
values ('987654321');

/*==== insert tai_khoan ====*/
insert into tai_khoan_gv(mat_khau)
values ('123456789');
insert into tai_khoan_gv(mat_khau)
values ('123456789');
insert into tai_khoan_gv(mat_khau)
values ('123456789');
insert into tai_khoan_gv(mat_khau)
values ('123456789');
insert into tai_khoan_gv(mat_khau)
values ('123456789');

/*==== insert lop ==== */
insert into lop
values ('to300', 'toeic 300');
insert into lop
values ('to450', 'toeic 450');
insert into lop
values ('to800', 'toeic 800');

/*==== insert phong ====*/
insert into phong
values ('ph001', 'phòng hành chính');
insert into phong
values ('ph002', 'phòng thu ngân');
insert into phong
values ('ph003', 'phòng kho');
insert into phong
values ('ph004', 'phòng học 1');
insert into phong
values ('ph005', 'phòng học 2');
insert into phong
values ('ph006', 'phòng học 3');
insert into phong
values ('ph007', 'phòng học 4');
insert into phong
values ('ph008', 'phòng học 5');

/*==== insert into khoa_hoc ====*/
insert into khoa_hoc
values ('kh001', 'toeic 300');
insert into khoa_hoc
values ('kh002', 'toeic 450');
insert into khoa_hoc
values ('kh003', 'toeic 800');
insert into khoa_hoc
values ('kh004', 'toeic 900');

/*==== insert lich_hoc ====*/
insert into lich_hoc
values ('100', '100', 'to300', 'ph004');
insert into lich_hoc
values ('101', '100', 'to300', 'ph004');
insert into lich_hoc
values ('102', '100', 'to300', 'ph004');
insert into lich_hoc
values ('103', '100', 'to300', 'ph004');
insert into lich_hoc
values ('104', '100', 'to300', 'ph004');
insert into lich_hoc
values ('105', '101', 'to450', 'ph005');
insert into lich_hoc
values ('106', '101', 'to450', 'ph005');
insert into lich_hoc
values ('107', '101', 'to450', 'ph005');
insert into lich_hoc
values ('108', '101', 'to450', 'ph005');
insert into lich_hoc
values ('109', '101', 'to450', 'ph005');
insert into lich_hoc
values ('110', '102', 'to800', 'ph006');
insert into lich_hoc
values ('111', '102', 'to800', 'ph006');
insert into lich_hoc
values ('112', '102','to800', 'ph006');
insert into lich_hoc
values ('113', '102','to800', 'ph006');
insert into lich_hoc
values ('114', '102','to800', 'ph006');

/*==== insert lich_day ====*/
insert into lich_day
values ('100', 'to300', 'ph004');
insert into lich_day
values ('101', 'to450', 'ph005');
insert into lich_day
values ('102', 'to800', 'ph006');

/*==== insert lich_thi ====*/
insert into lich_thi
values ('100', 'ph006', 'to300');
insert into lich_thi
values ('101', 'ph006', 'to300');
insert into lich_thi
values ('102', 'ph006', 'to300');
insert into lich_thi
values ('103', 'ph006', 'to300');
insert into lich_thi
values ('104', 'ph006', 'to300');
insert into lich_thi
values ('105', 'ph007', 'to450');
insert into lich_thi
values ('106', 'ph007', 'to450');
insert into lich_thi
values ('107', 'ph007', 'to450');
insert into lich_thi
values ('108', 'ph007', 'to450');
insert into lich_thi
values ('109', 'ph007', 'to450');
insert into lich_thi
values ('110', 'ph008', 'to800');
insert into lich_thi
values ('111', 'ph008', 'to800');
insert into lich_thi
values ('112', 'ph008', 'to800');
insert into lich_thi
values ('113', 'ph008', 'to800');
insert into lich_thi
values ('114', 'ph008', 'to800');
