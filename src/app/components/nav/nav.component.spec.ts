// import { async, ComponentFixture, TestBed } from '@angular/core/testing';
// import { FormsModule } from '@angular/forms';
// import { By } from '@angular/platform-browser';
// import { HttpModule } from '@angular/http';
// import { RouterTestingModule } from '@angular/router/testing';
// import { NO_ERRORS_SCHEMA } from '@angular/core';

// import { NavComponent } from './nav.component';


// describe('NavComponent', () => {
//   let component: NavComponent;
//   let fixture: ComponentFixture<NavComponent>;
//   let ulElement;

//   beforeEach(async(() => {
//     TestBed.configureTestingModule({
//       imports: [FormsModule, HttpModule, RouterTestingModule],
//       declarations: [NavComponent],
//       schemas: [NO_ERRORS_SCHEMA]
//     })
//       .compileComponents();
//   }));

//   beforeEach(() => {
//     fixture = TestBed.createComponent(NavComponent);
//     component = fixture.componentInstance;
//     ulElement = fixture.debugElement.queryAll(By.css('ul'));
//     // fixture.detectChanges();
//   });

//   it('should be created', () => {
//     expect(component).toBeTruthy();
//   });

//   it(`should have nav element`, async(() => {
//     const navElement = fixture.debugElement.queryAll(By.css('nav'));
//     expect(navElement.length).toBe(1);
//   }));

//   it(`should have anchor element`, async(() => {
//     const anchorElement = fixture.debugElement.queryAll(By.css('a'));
//     expect(anchorElement).toBeTruthy();
//   }));

//   it(`should have 2 unordered list elements`, async(() => {
//     expect(ulElement.length).toBe(2);
//   }));
// });
