package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskDetails {
   public Integer id;
   public String reference;
   public String title;
   public String description;
   public String date_creation;
   public String date_modification;
   public String date_completed;
   public String date_due;
   public String color_id;
   public Integer projectid;
   public String column_id;
   public String swimlane_id;
   public String owner_id;
   public String creator_id;
   public String position;
   public String is_active;
   public String score;
   public String category_id;
   public String date_moved;
   public String recurrence_status;
   public String recurrence_trigger;
   public String recurrence_factor;
   public String recurrence_timeframe;
   public String recurrence_basedate;
   public String recurrence_parent;
   public String recurrence_child;
   public String assignee_username;
   public String assignee_name;
   public String nb_comments;
   public String nb_files;
   public String nb_subtasks;
   public String nb_completed_subtasks;
   public String nb_links;
//   private List<TaskColorDetails> color;
}
