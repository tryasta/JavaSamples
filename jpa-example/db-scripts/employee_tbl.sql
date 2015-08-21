CREATE 
TABLE	employee
	(
		id bigint NOT NULL,
		first_name character varying(255) NOT NULL,
		last_name  character varying(255) NOT NULL,
		salary numeric(10, 2),
		start_date date NOT NULL,
		end_date date,
		manager_id bigint NOT NULL,
		address_id bigint NOT NULL,
		CONSTRAINT employee_pkey PRIMARY KEY (id),
		CONSTRAINT manager_fkey FOREIGN KEY (manager_id)
			REFERENCES employee (id),
		CONSTRAINT address_fkey FOREIGN KEY (address_id)
			REFERENCES address (id)
	)
;
