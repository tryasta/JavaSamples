﻿DROP TABLE
	phone
;

CREATE 
TABLE	phone
	(
		id bigint NOT NULL,
		type character varying(20) NOT NULL,
		phone_number character varying(15) NOT NULL,
		country_code character varying(5) NOT NULL,
		owner_id bigint NOT NULL,
		CONSTRAINT phone_pkey PRIMARY KEY (id),
		CONSTRAINT owner_fkey FOREIGN KEY (owner_id)
			REFERENCES employee (id)
	)
;
