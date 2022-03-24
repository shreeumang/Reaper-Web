import { Component, Input, OnInit, ViewChild } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import { AppComponent } from 'app/app.component';
import { Message } from 'app/message';
import { MessageService } from 'app/message.service';



@Component({
  selector: 'add-edit',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  userForm: FormGroup;
  durability = [];
  type = [];
  public editMessage: Message;

  showModal= -1;
  @Input() listdata;


  constructor(private fb: FormBuilder,private messageService: MessageService, private child: AppComponent) {
    this.userForm = this.fb.group({
      name:['',Validators.required],
      type:[''],
      durability:[''],
      autoDelete:[false, Validators.requiredTrue]
    });
    this.setData();

   }

  ngOnInit() {
  }

   getType(){
     return [
      { id: '1', name: 'Classic' },
      { id: '2', name: 'Quorum' },
     ];
   }

   getDurability(){
     return [
      { id: '1', name: 'Durable' },
      { id: '2', name: 'Trancient' },
     ];
   }


   public addItem(): void {
      if(this.userForm.value['name']!=''){
        // this.listdata.push(this.userForm.value);
        this.messageService.addMessage(this.userForm.value).subscribe(
          (response) => {
            console.log(response);
            this.child.ngOnInit();
          },
          (error: any) => {
            alert(error.message);
          }
        );
       }
     this.userForm.get('name').setValue('');
     this.userForm.get('autoDelete').setValue(false);
     this.setData();
     this.showModal = -1;
   }

   public setData(){
    this.type = this.getType();
    this.durability = this.getDurability();
   }


  close() {
    this.userForm.get('name').setValue('');
    this.userForm.get('autoDelete').setValue(false);
    this.setData();
    this.showModal = -1;
  }


  deleteList() {
    this.messageService.deleteMessage(this.editMessage.id).subscribe(
      (response) => {
        console.log(response);
        this.child.ngOnInit();
      },
      (error: any) => {
        alert(error.message);
      }
    );
    this.showModal=-1;
  }


  public onUpdateMessage(message: Message):void {
    // console.log("====>",this.editMessage);
    // console.log("<<<<<<<<>",this.userForm.value);
    this.editMessage.name=this.userForm.value.name;
    this.editMessage.type=this.userForm.value.type;
    this.editMessage.durability=this.userForm.value.durability;
    this.editMessage.autoDelete=this.userForm.value.autoDelete;

    // console.log("====>",this.editMessage);
    this.messageService.updateMessage(message).subscribe(
     (response) => {
       console.log(response);
       this.child.getMessages();
     },
     (error: any) => {
       alert(error.message);
     }
   );
   this.userForm.get('name').setValue('');
    this.userForm.get('autoDelete').setValue(false);
    this.setData();
    this.showModal = -1;

  }

  public onOpenModal(message: Message, mode: string){
    if(mode === 'add'){
      this.showModal=1;
    }
    if(mode === 'edit'){
      this.editMessage=message;
      this.userForm.get('name').setValue(message.name);
      this.userForm.get('autoDelete').setValue(message.autoDelete=="true"?true:false);
      this.userForm.get('durability').setValue(message.durability);
      this.userForm.get('type').setValue(message.type);
      this.showModal=3;
    }
    if(mode === 'delete'){
      this.editMessage=message;
      this.showModal=2;

    }
  }

}
