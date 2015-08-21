DROP TABLE
	project
;

CREATE 
TABLE	project
	(
		id bigint NOT NULL,
		type int NOT NULL,
		name  character varying(255) NOT NULL,
		description text NOT NULL,
		budget numeric(20, 2) NOT NULL,
		leader_id bigint NOT NULL,
		CONSTRAINT project_pkey PRIMARY KEY (id),
		CONSTRAINT leader_fkey FOREIGN KEY (leader_id)
			REFERENCES employee (id)
	)
;
