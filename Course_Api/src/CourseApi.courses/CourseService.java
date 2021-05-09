package course_api.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;


	public List<Course> getallCourse(String topicId){
		
		List<Course> courses=new ArrayList<>();
		courseRepository.findByTopicId(topicId)
		.forEach(courses::add);
		return courses;
	}	

	public Course getCourse(String id) {
		//return topics.stream().filter(t->t.getId().equals(id)).findFirst().get();
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
		}
		
	

	public void  deleteCourse(String id) {
		courseRepository.deleteById(id);
		
	}
}
