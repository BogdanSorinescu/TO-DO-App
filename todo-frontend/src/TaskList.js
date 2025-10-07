import React, { useState, useEffect } from 'react';

function TaskList() {
    const [tasks, setTasks] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/api/tasks')
            .then(response => response.json())
            .then(data => setTasks(data))
            .catch(error => console.error('Could not fetch tasks:', error));
    }, []);

    const hondleAddTask = (e) =>{
        
    }

    return (
        <div>
            <h1>To-Do List</h1>
            <ul>
                {tasks.map(task => (
                    <li key={task.id}>{task.name}</li> // use the correct field from your entity
                ))}
            </ul>
        </div>
    );
}

export default TaskList;
