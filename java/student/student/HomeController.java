package student.student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value ="/" )
    public String indexPage(Model model){
        ArrayList<Student>arrayList=DBStudent.getDBStudents();
        model.addAttribute("studenty",arrayList);
        return "students";

    }
     @GetMapping(value="/addStudentPage")
        public String addStudent(){
            return "addStudentPage";
     }
     @PostMapping(value = "/addStudentPage")
        public String addStudent(@RequestParam(name = "studentName") String name,
                                 @RequestParam(name = "studentSurname")String surname,
                                 @RequestParam(name = "studentExam")int exam){

        Student student= new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setExam(exam);
         if (exam>90 && exam<100){
             student.setMark("A");
         } else if (exam>75 && exam<90) {
             student.setMark("B");
         }
          else if (exam>60 && exam<75) {

             student.setMark("C");
         }
         else if (exam>50 && exam<60){
             student.setMark("D");
         }
         else {
             student.setMark("F");
         }
         DBStudent.addStudent(student);
         return "redirect:/";



                }
}




