CREATE 
TABLE 	address
	(
		id bigint NOT NULL,
		street character varying(255) NOT NULL,
		city character varying(100) NOT NULL,
		state character varying(100),
		country character varying(100) NOT NULL,
		postcode character varying(50) NOT NULL,
		CONSTRAINT address_pkey PRIMARY KEY (id)
	)
;
