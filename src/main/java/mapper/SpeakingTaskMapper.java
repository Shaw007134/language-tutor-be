package mapper;

import com.zsy.language_tutor.request.SpeakingTaskQuery;
import com.zsy.language_tutor.model.SpeakingTask;

import java.util.List;

public interface SpeakingTaskMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SpeakingTask record);

    int insertSelective(SpeakingTask record);

    SpeakingTask selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SpeakingTask record);

    int updateByPrimaryKey(SpeakingTask record);

    List<SpeakingTask> getQuestions(SpeakingTaskQuery query);

    int countSpeakingTasks(SpeakingTaskQuery request);
}