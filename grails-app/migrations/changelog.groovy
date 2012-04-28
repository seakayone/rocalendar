databaseChangeLog = {

	changeSet(author: "christian (generated)", id: "1335554837686-1") {
		createTable(tableName: "event") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "eventPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(1500)") {
				constraints(nullable: "false")
			}

			column(name: "end_date", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "entry_fee", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "filename_flyer", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "start_date", type: "timestamp") {
				constraints(nullable: "false")
			}

			column(name: "venue_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-2") {
		createTable(tableName: "persistent_session") {
			column(name: "id", type: "varchar(255)") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "persistent_sePK")
			}

			column(name: "creation_time", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "invalidated", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "last_accessed_time", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "max_inactive_interval", type: "int4") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-3") {
		createTable(tableName: "persistent_session_attribute") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "persistent_sePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "session_id", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-4") {
		createTable(tableName: "persistent_session_attribute_value") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "persistent_sePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "attribute_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "serialized", type: "bytea(20000)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-5") {
		createTable(tableName: "person_event") {
			column(name: "person_events_id", type: "int8")

			column(name: "event_id", type: "int8")
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-6") {
		createTable(tableName: "person_venue") {
			column(name: "person_venues_id", type: "int8")

			column(name: "venue_id", type: "int8")
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-7") {
		createTable(tableName: "profile") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "profilePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "email", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-8") {
		createTable(tableName: "sec_role") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "sec_rolePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false", unique: "true")
			}
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-9") {
		createTable(tableName: "sec_user") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "sec_userPK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bool") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false", unique: "true")
			}

			column(name: "class", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "profile_id", type: "int8") {
				constraints(unique: "true")
			}
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-10") {
		createTable(tableName: "sec_user_sec_role") {
			column(name: "sec_role_id", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "sec_user_id", type: "int8") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-11") {
		createTable(tableName: "venue") {
			column(name: "id", type: "int8") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "venuePK")
			}

			column(name: "version", type: "int8") {
				constraints(nullable: "false")
			}

			column(name: "city", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "country", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "description", type: "varchar(1500)") {
				constraints(nullable: "false")
			}

			column(name: "lat", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "lng", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "varchar(100)") {
				constraints(nullable: "false")
			}

			column(name: "state", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "street", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "url", type: "varchar(255)")

			column(name: "zip", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-12") {
		addPrimaryKey(columnNames: "sec_role_id, sec_user_id", constraintName: "sec_user_sec_PK", tableName: "sec_user_sec_role")
	}

	changeSet(author: "christian (generated)", id: "1335554837686-13") {
		createIndex(indexName: "authority_unique_1335554837618", tableName: "sec_role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-14") {
		createIndex(indexName: "profile_id_unique_1335554837624", tableName: "sec_user", unique: "true") {
			column(name: "profile_id")
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-15") {
		createIndex(indexName: "username_unique_1335554837623", tableName: "sec_user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "christian (generated)", id: "1335554837686-16") {
		addForeignKeyConstraint(baseColumnNames: "venue_id", baseTableName: "event", constraintName: "FK5C6729A24DD700F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "venue", referencesUniqueColumn: "false")
	}

	changeSet(author: "christian (generated)", id: "1335554837686-17") {
		addForeignKeyConstraint(baseColumnNames: "session_id", baseTableName: "persistent_session_attribute", constraintName: "FK50C6048B92381D29", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "persistent_session", referencesUniqueColumn: "false")
	}

	changeSet(author: "christian (generated)", id: "1335554837686-18") {
		addForeignKeyConstraint(baseColumnNames: "attribute_id", baseTableName: "persistent_session_attribute_value", constraintName: "FK1EFE24BDF830ABF5", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "persistent_session_attribute", referencesUniqueColumn: "false")
	}

	changeSet(author: "christian (generated)", id: "1335554837686-19") {
		addForeignKeyConstraint(baseColumnNames: "event_id", baseTableName: "person_event", constraintName: "FKECD7DD30B193FC2F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "event", referencesUniqueColumn: "false")
	}

	changeSet(author: "christian (generated)", id: "1335554837686-20") {
		addForeignKeyConstraint(baseColumnNames: "person_events_id", baseTableName: "person_event", constraintName: "FKECD7DD30675E66D7", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "sec_user", referencesUniqueColumn: "false")
	}

	changeSet(author: "christian (generated)", id: "1335554837686-21") {
		addForeignKeyConstraint(baseColumnNames: "person_venues_id", baseTableName: "person_venue", constraintName: "FKEDBFD505412C6C2C", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "sec_user", referencesUniqueColumn: "false")
	}

	changeSet(author: "christian (generated)", id: "1335554837686-22") {
		addForeignKeyConstraint(baseColumnNames: "venue_id", baseTableName: "person_venue", constraintName: "FKEDBFD50524DD700F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "venue", referencesUniqueColumn: "false")
	}

	changeSet(author: "christian (generated)", id: "1335554837686-23") {
		addForeignKeyConstraint(baseColumnNames: "profile_id", baseTableName: "sec_user", constraintName: "FK375DF2F95FC0148F", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "profile", referencesUniqueColumn: "false")
	}

	changeSet(author: "christian (generated)", id: "1335554837686-24") {
		addForeignKeyConstraint(baseColumnNames: "sec_role_id", baseTableName: "sec_user_sec_role", constraintName: "FK6630E2AA218A772", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "sec_role", referencesUniqueColumn: "false")
	}

	changeSet(author: "christian (generated)", id: "1335554837686-25") {
		addForeignKeyConstraint(baseColumnNames: "sec_user_id", baseTableName: "sec_user_sec_role", constraintName: "FK6630E2A47436B52", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "sec_user", referencesUniqueColumn: "false")
	}

	changeSet(author: "christian (generated)", id: "1335554837686-26") {
		createSequence(sequenceName: "hibernate_sequence")
	}

	include file: 'add-date-last-update-create-to-venue.groovy'
}
