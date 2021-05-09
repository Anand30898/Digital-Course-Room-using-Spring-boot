package course_api.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository <Course,String>{

		public List<Course> findByTopicId(String topicId);
		
		/*there is trick well not exactly a trick to make JPA give the
		 * specific query the we want the steps to make such as follows 
		 * select the name by find keyword the write By and then
		 * the parameter that you want to find in my case it is the 
		 * topic so the name can be initialized as findByTopicId */
}
