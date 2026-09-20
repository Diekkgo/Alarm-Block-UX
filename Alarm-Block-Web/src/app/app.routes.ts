import { Routes } from '@angular/router';
import { Login } from './components/login/login';
import { Dashboard } from './components/dashboard/dashboard';
import { History } from './components/history/history';
import { NewAlarm } from './components/new-alarm/new-alarm';
import { Preferences } from './components/preferences/preferences';
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
        path: 'history',
        component: History
    },
    {
        path: 'new-alarm',
        component: NewAlarm
    },
    {
        path: 'preferences',
        component: Preferences
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
