import { Routes } from '@angular/router';
import { Login } from './components/login/login';
import { Dashboard } from './components/dashboard/dashboard';
import { RecurringAlarms } from './components/recurring-alarms/recurring-alarms';


export const routes: Routes = [
    {
        path: 'login',
        component: Login
    },
    {
        path: 'dashboard',
        component: Dashboard
    },
    {
        path: 'recurring-alarms',
        component: RecurringAlarms
    },
    {
        path: '**',
        component: Login
    }
];
