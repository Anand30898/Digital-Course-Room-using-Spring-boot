package course_api.courses;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import course_api.topic.Topic;

@RestController
public class CoursesController {
	
	@Autowired
	private CourseService courseService;
	
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getCourse(@PathVariable String id) {
		return courseService.getallCourse(id);
				}
	@RequestMapping("/topics/{topicID}/courses/{id}")
	public Course getAllCourse( @PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/topics/{topicID}/courses/")
	public void addCourse(@RequestBody Course course,@PathVariable String topicId) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.addCourse(course);
	}
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{topicID}/courses/{id}")
	public void updateCourse(@RequestBody Course course,@PathVariable String topicId,@PathVariable String id) {
		course.setTopic(new Topic(topicId,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{topicID}/courses/{id}")
	public void  deleteCourse( @PathVariable String id) {
		courseService.deleteCourse(id);
	}
}
