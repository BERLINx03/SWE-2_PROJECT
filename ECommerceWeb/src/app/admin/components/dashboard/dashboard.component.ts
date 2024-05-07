import { Component } from '@angular/core';
import { AdminService } from '../../service/admin.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {

  products:any []= [];
  searchProductForm!: FormGroup;

  constructor(
    private adminService:AdminService,
    private fb: FormBuilder,
    private snackBar:MatSnackBar
  ){}

  ngOnInit():void{
    this.getAllProducts();
    this.searchProductForm = this.fb.group({
      title: [null, [Validators.required]]
    })
  }

  getAllProducts(){
    this.products = [];
    this.adminService.getAllProducts().subscribe(res => {
      res.forEach(element => {
        element.processedImg = 'data:image/jpeg;base64,'+element.byteImg;
        this.products.push(element);
      });
      console.log(this.products);
    })
  }

  submitForm(){
    this.products = [];
    const title = this.searchProductForm.get('title')?.value;
    this.adminService.getAllProductsByName(title).subscribe(res => {
      res.forEach(element => {
        element.processedImg = 'data:image/jpeg;base64,'+element.byteImg;
        this.products.push(element);
      });
      console.log(this.products);
    })
  }
  // deleteProduct(productId:any){
  //   this.adminService.deleteProduct(productId).subscribe(res => {
  //     if(res.body == null){
  //       this.snackBar.open('Product Deleted Successfully!','Close',{
  //         duration:5000
  //       });    
  //       this.getAllProducts(); 
  //     }else{
  //       this.snackBar.open(res.message,'Close',{
  //         duration:5000,
  //         panelClass : 'error-snackbar'
  //       });
  //     }
  //   })
  // }
  deleteProduct(productId: any) {
    this.adminService.deleteProduct(productId).subscribe(res => {
        console.log('Delete product response:', res);
        if (res?.body == null) { // Use optional chaining (?.) to safely access res.body
            this.snackBar.open('Product Deleted Successfully!', 'Close', {
                duration: 5000
            });
            // Remove the deleted product from the products array
            this.products = this.products.filter(product => product.id !== productId);
            console.log('Updated products array:', this.products);
        } else {
            this.snackBar.open(res.message || 'Error deleting product', 'Close', { // Provide a default message if res.message is null
                duration: 5000,
                panelClass: 'error-snackbar'
            });
        }
    }, error => {
        console.error('Error deleting product:', error);
        this.snackBar.open('Error deleting product', 'Close', {
            duration: 5000,
            panelClass: 'error-snackbar'
        });
    });
}




}
