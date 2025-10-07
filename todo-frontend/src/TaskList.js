import React, { useState, useEffect } from 'react';
import './TaskList.scss'; // ✅ Import your SCSS file

function TaskList() {
  const [tasks, setTasks] = useState([]);
  const [newTask, setNewTask] = useState('');

  // Fetch tasks from backend
  useEffect(() => {
    fetch('http://localhost:8080/api/tasks')
      .then(response => response.json())
      .then(data => setTasks(data))
      .catch(error => console.error('Could not fetch tasks:', error));
  }, []);

  // Add task
  const handleAddTask = () => {
    if (newTask.trim() === '') return;

    const taskData = { title: newTask, completed: false };

    fetch('http://localhost:8080/api/tasks', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(taskData),
    })
      .then(response => response.json())
      .then(savedTask => {
        setTasks([...tasks, savedTask]);
        setNewTask('');
      })
      .catch(error => console.error('Error adding task:', error));
  };

  // Delete task
  const handleDelete = (id) => {
    fetch(`http://localhost:8080/api/tasks/${id}`, {
      method: 'DELETE',
    })
      .then(() => {
        setTasks(tasks.filter(task => task.id !== id));
      })
      .catch(error => console.error('Error deleting task:', error));
  };

  // Toggle completion
  const toggleComplete = (task) => {
    const updatedTask = { ...task, completed: !task.completed };

    fetch(`http://localhost:8080/api/tasks/${task.id}`, {
      method: 'PUT',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(updatedTask),
    })
      .then(response => response.json())
      .then(data => {
        setTasks(tasks.map(t => (t.id === data.id ? data : t)));
      })
      .catch(error => console.error('Error updating task:', error));
  };

  return (
    <div className="task-container">
      <h1>📝 To-Do List</h1>

      <div className="input-section">
        <input
          type="text"
          value={newTask}
          onChange={(e) => setNewTask(e.target.value)}
          placeholder="Add new task..."
        />
        <button onClick={handleAddTask}>Add</button>
      </div>

      <ul className="task-list">
        {tasks.map(task => (
          <li key={task.id} className={task.completed ? 'completed' : ''}>
            <span onClick={() => toggleComplete(task)}>
              {task.title}
            </span>
            <button onClick={() => handleDelete(task.id)}>Delete</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TaskList;
