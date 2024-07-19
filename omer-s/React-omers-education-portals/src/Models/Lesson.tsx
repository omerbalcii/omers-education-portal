// src/models/Lesson.tsx
import { Course } from './Course';

export interface Lesson {
    id: number;
    name: string;
    title: string;
    content: string;
    course: Course;
}
