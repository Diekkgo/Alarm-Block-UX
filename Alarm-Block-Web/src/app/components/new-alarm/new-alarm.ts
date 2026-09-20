import { Component, inject, signal } from '@angular/core';
import { NgFor, NgIf } from '@angular/common';
import { Router, RouterLink } from '@angular/router';

interface DayOption {
  label: string;
  fullName: string;
}

@Component({
  selector: 'app-new-alarm',
  imports: [RouterLink, NgFor, NgIf],
  templateUrl: './new-alarm.html',
  styleUrl: './new-alarm.css',
})
export class NewAlarm {

  private readonly router = inject(Router);

  readonly showSavedModal = signal(false);

  readonly days: DayOption[] = [
    { label: 'L', fullName: 'Lunes' },
    { label: 'M', fullName: 'Martes' },
    { label: 'M', fullName: 'Miércoles' },
    { label: 'J', fullName: 'Jueves' },
    { label: 'V', fullName: 'Viernes' },
    { label: 'S', fullName: 'Sábado' },
    { label: 'D', fullName: 'Domingo' },
  ];

  private readonly selectedDays = signal<ReadonlySet<number>>(new Set());

  isDaySelected(index: number): boolean {
    return this.selectedDays().has(index);
  }

  toggleDay(index: number): void {
    const updated = new Set(this.selectedDays());
    updated.has(index) ? updated.delete(index) : updated.add(index);
    this.selectedDays.set(updated);
  }

  onSave(): void {
    this.showSavedModal.set(true);
  }

  closeModal(): void {
    this.showSavedModal.set(false);
    this.router.navigate(['/recurring-alarms']);
  }

}
