CREATE TABLE "Student" (
	"id" serial NOT NULL,
	"first_name" varchar NOT NULL,
	"last_name" varchar NOT NULL,
	CONSTRAINT Student_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Topic" (
	"id" serial NOT NULL,
	"name" varchar NOT NULL,
	CONSTRAINT Topic_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Assessment" (
	"id" serial NOT NULL,
	"name" varchar NOT NULL,
	CONSTRAINT Assessment_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "Summary_table" (
	"id" serial NOT NULL,
	"student_id" bigint NOT NULL,
	"topic_id" bigint NOT NULL,
	"assessment_id" bigint NOT NULL,
	"value" varchar NOT NULL,
	CONSTRAINT Summary_table_pk PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);






ALTER TABLE "Summary_table" ADD CONSTRAINT "Summary_table_fk0" FOREIGN KEY ("student_id") REFERENCES "Student"("id");
ALTER TABLE "Summary_table" ADD CONSTRAINT "Summary_table_fk1" FOREIGN KEY ("topic_id") REFERENCES "Topic"("id");
ALTER TABLE "Summary_table" ADD CONSTRAINT "Summary_table_fk2" FOREIGN KEY ("assessment_id") REFERENCES "Assessment"("id");

