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
public class ColumnDetails {
    private Integer id;
    private String title;
    private Integer position;
    private Integer project_id;
    private Integer task_limit;
    private Integer hide_in_dashboard;
    private String description;
    private List<TaskDetails> tasks;
    private Integer nb_open_tasks;
    private Integer nb_tasks;
    private Integer nb_closed_tasks;
    private Integer score;
    private Integer column_nb_tasks;
    private Integer column_score;
    private Integer column_nb_score;
    private Integer column_nb_open_tasks;
}
