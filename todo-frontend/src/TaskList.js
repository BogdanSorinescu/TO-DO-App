import React,{ useState, useEffect } from 'react';

function TaskList() {
    useEffect(() => {
        fetch('http://localhost:8080/api/tasks')

        .then(response=>response.json())
        .then(data => setTask(data))
        .catch(error => consol.error('Couldnt fetch tasks:',error));

        },[]);
}