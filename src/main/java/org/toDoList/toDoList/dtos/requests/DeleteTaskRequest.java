package org.toDoList.toDoList.dtos.requests;

import lombok.Getter;
import lombok.Setter;
import org.toDoList.toDoList.data.models.Status;

@Getter
@Setter
public class DeleteTaskRequest {

    private Status status;

}
