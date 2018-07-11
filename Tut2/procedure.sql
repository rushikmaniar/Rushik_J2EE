delimiter ;;

drop procedure if exists getStudRecords;;

create procedure getStudRecords(
    INOUT StudID INT,
    INOUT StudName VARCHAR(255),
    OUT mark1 INT,
	OUT mark2 INT,
    OUT mark3 INT,
    OUT total INT,
    OUT percentage FLOAT,
    OUT grade VARCHAR(255)
) 
	BEGIN 
	SELECT 
    student_details.Stud_Id INTO StudID, 
    student_details.Stud_Name INTO StudName,
    student_marksheet.Mark1 INTO mark1,
    student_marksheet.Mark2 INTO mark2,
    student_marksheet.Mark3 INTO mark3,
    student_marksheet.Total INTO total,
    student_marksheet.Percentage INTO percentage,
    student_marksheet.Grade INTO grade 
   
    
	FROM student_details
	LEFT JOIN student_marksheet ON student_details.Stud_Id = student_marksheet.Stud_Id
	WHERE student_details.Stud_Id = StudID OR student_details.Stud_Name LIKE "%$StudName%"; 
	END

;;
