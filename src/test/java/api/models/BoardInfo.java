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
public class BoardInfo {
    private Integer project_id;
    private Integer is_active;
    private Integer id;
    private String name;
    private String description;
    private List<ColumnDetails> columns;
    private Integer nb_columns;
    private Integer task_limit;
    private Integer nb_swimlanes;
    private Integer nb_tasks;
    private Integer score;
}
