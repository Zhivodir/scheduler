<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <div class="row">
        <div class="modal fade" id="modalForNewTask" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">Create new Task</h4>
                    </div>
                    <div class="modal-body">
                        <form action="createNewTask" method="post">
                            <div class="form-group">
                                <label class="sr-only" for="description">description</label>
                                <input type="text" class="form-control" id="description" name="description"
                                       placeholder="Enter description of task">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="content">content</label>
                                <input type="text" class="form-control" id="content" name="content"
                                       placeholder="Enter content of task">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="priority">priority</label>
                                <input type="text" class="form-control" id="priority" name="priority"
                                       placeholder="Enter priority of task">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="type_of_task">type</label>
                                <select name="type_of_task" id="type_of_task" class="form-control">
                                    <option value="without_param">Без параметров</option>
                                    <option value="dated">Датированная</option>
                                    <option value="periodic">Периодическая</option>
                                    <option value="everyday">Ежедневная</option>
                                </select>
                            </div>

                            <%-----------------%>
                            <%-- hidden part --%>
                            <%-----------------%>

                            <%-- Dates task --%>
                            <div class="form-group hidden_task" id="dated_task" hidden>
                                <div class="multiple create_task"></div>
                                <input type="text" class="form-control inputDisabled" id="result" name="task_dates" hidden disabled>
                            </div>

                            <%-- Days task --%>
                            <div class="form-group hidden_task" id="periodic_task" hidden>
                                <div class="well well-sm text-center">
                                    <div class="btn-group" data-toggle="buttons">
                                        <label class="btn btn-danger">
                                            <input type="checkbox" name="day_of_week" autocomplete="off" class="day_of_week" value="1"  disabled>Su
                                        </label>
                                        <label class="btn btn-success">
                                            <input type="checkbox" name="day_of_week" autocomplete="off" class="day_of_week" value="2" disabled>Mo
                                        </label>
                                        <label class="btn btn-primary">
                                            <input type="checkbox" name="day_of_week" autocomplete="off" class="day_of_week" value="3"  disabled>Tu
                                        </label>
                                        <label class="btn btn-info">
                                            <input type="checkbox" name="day_of_week" autocomplete="off" class="day_of_week" value="4"  disabled>We
                                        </label>
                                        <label class="btn btn-default">
                                            <input type="checkbox" name="day_of_week" autocomplete="off" class="day_of_week" value="5"  disabled>Th
                                        </label>
                                        <label class="btn btn-warning">
                                            <input type="checkbox" name="day_of_week" autocomplete="off" class="day_of_week" value="6"  disabled>Fr
                                        </label>
                                        <label class="btn btn-danger">
                                            <input type="checkbox" name="day_of_week" autocomplete="off" class="day_of_week" value="7"  disabled>Sa
                                        </label>
                                    </div>
                                </div>
                            </div>

                            <%-- Everyday task --%>
                            <div class="form-group hidden_task" id="everyday_task" hidden>
                                <label class="sr-only" for="everyday">type</label>
                                <input type="text" class="form-control inputDisabled" id="everyday" name="everyday"
                                       placeholder="Enter time of task3" disabled>
                            </div>
                            <button type="submit" class="btn btn-primary">Create</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
