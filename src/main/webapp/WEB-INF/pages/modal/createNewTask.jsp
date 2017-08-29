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
                                <input type="text" class="orm-control" id="description" name="description"
                                       placeholder="Enter description of task">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="content">content</label>
                                <input type="text" class="orm-control" id="content" name="content"
                                       placeholder="Enter content of task">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="priority">priority</label>
                                <input type="text" class="orm-control" id="priority" name="priority"
                                       placeholder="Enter priority of task">
                            </div>
                            <button type="submit" class="btn btn-primary">Create</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>