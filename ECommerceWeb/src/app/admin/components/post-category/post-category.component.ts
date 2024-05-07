import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { AdminService } from '../../service/admin.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-post-category',
  templateUrl: './post-category.component.html',
  styleUrls: ['./post-category.component.scss']
})
export class PostCategoryComponent {

  categoryForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private snackBar:MatSnackBar,
    private adminService:AdminService 
  ){ }

    ngOnInit():void{
      this.categoryForm = this.fb.group({
        name: [null, [Validators.required]],
        description: [null, [Validators.required]],
      })
    }
    
  /**
   * Adds a new category to the system.
   *
   * This method is called when the user submits the category form. It first checks if the form is valid, and if so, it calls the `addCategory` method on the `adminService` to create a new category. If the category is created successfully, it displays a success snackbar and navigates to the admin dashboard. If there is an error, it displays an error snackbar.
   */
  addCategory(): void {
    if (this.categoryForm.valid) {
      this.adminService
        .addCategory(this.categoryForm.value)
        .subscribe((res) => {
          if (res.id != null) {
            this.snackBar.open('Category Posted successfully!', 'Close', {
              duration: 5000,
            });
            this.router.navigateByUrl('/admin/dashboard');
          } else {
            this.snackBar.open(res.message, 'Close', {
              duration: 5000,
              panelClass: 'error-snackbar',
            });
          }
        });
    } else {
      this.categoryForm.markAllAsTouched();
    }
  }
}
