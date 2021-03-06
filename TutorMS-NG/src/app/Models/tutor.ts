import { Course } from "src/app/Models/Course";
import { Schedule } from "src/app/Models/Schedule";

export class Tutor{
  id: number;
	firstName: string;
	lastName: string;
	userName: string;
	schoolEmail: string;
	password: string;
	phoneNumber: string;
	accountTypeId: number;
  schedule: Schedule;
  coursesToTutor: [Course];

  constructor(id: number, firstName: string, lastName: string, userName: string, schoolEmail: string, password: string, phoneNumber: string, accountTypeId: number, 
    schedule: Schedule, coursesToTutor: [Course] ){
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.userName = userName;
    this.schoolEmail = schoolEmail;
    this.password = password;
    this.phoneNumber = phoneNumber;
    this.accountTypeId = accountTypeId;
    this.schedule = schedule;
    this.coursesToTutor = coursesToTutor;
  }
}
  