import { Component, signal } from '@angular/core';
import { NgIf } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-preferences',
  imports: [RouterLink, NgIf],
  templateUrl: './preferences.html',
  styleUrl: './preferences.css',
})
export class Preferences {

  readonly showSavedModal = signal(false);

  onSave(): void {
    this.showSavedModal.set(true);
  }

  closeModal(): void {
    this.showSavedModal.set(false);
  }

}
