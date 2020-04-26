/* show databases; */

use jmypicture;

create or replace table picture (
	pic_id			char(36)		not null default UUID(),
	pic_cr_date		datetime		not null default now(),
	pic_name		varchar(1024)	not null,
	pic_isvalid		bool			not null default true,
	pic_width		int,
	pic_height		int,
	pic_weight		int,
	constraint pk_picture primary key (pic_id)
) engine=MyISAM;

create or replace table tag (
	tag_id			char(36)		not null default UUID(),
	tag_cr_date		datetime		not null default now(),
	tag_name		varchar(50)		not null,
	tag_value		varchar(50)		not null,
	tag_isvalid		bool			not null default true,
	constraint pk_tag primary key (tag_id)
) engine=MyISAM;

create or replace table pic_tag (
	pt_pic_id		char(36)		not null,
	pt_tag_id		char(36)		not null,
	pt_cr_date		datetime		not null default now(),
	pt_isvalid		bool			not null,
	constraint pk_pt primary key (pt_pic_id, pt_tag_id)
) engine=MyISAM;

alter table pic_tag
	add constraint un_pt unique key (pt_tag_id, pt_pic_id),
	add constraint fk_pic_id foreign key (pt_pic_id) references picture (pic_id) on delete cascade,
	add constraint fk_tag_id foreign key (pt_tag_id) references tag (tag_id) on delete cascade;

create or replace trigger trau_disab_picture
after update on picture for each row
update pic_tag 
	set pt_isvalid = picture.pic_isvalid 
	where picture.pic_id = pic_tag.pt_pic_id;

create or replace trigger trau_disab_pic_tag
after update on tag for each row
update pic_tag 
	set pt_isvalid = tag.tag_isvalid 
	where tag.tag_id = pic_tag.pt_tag_id;

