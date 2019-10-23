document.addEventListener("DOMContentLoaded", function() {

  /**
   * Form Select
   */
  class FormSelect {
    constructor($el) {
      this.$el = $el;
      this.options = [...$el.children];
      this.init();
    }

    init() {
      this.createElements();
      this.addEvents();
      this.$el.parentElement.removeChild(this.$el);
    }

    createElements() {
      // Input for value
      this.valueInput = document.createElement("input");
      this.valueInput.type = "text";
      this.valueInput.name = this.$el.name;

      // Dropdown container
      this.dropdown = document.createElement("div");
      this.dropdown.classList.add("dropdown");

      // List container
      this.ul = document.createElement("ul");

      // All list options
      this.options.forEach((el, i) => {
        const li = document.createElement("li");
        li.dataset.value = el.value;
        li.innerText = el.innerText;

        if (i === 0) {
          // First clickable option
          this.current = document.createElement("div");
          this.current.innerText = el.innerText;
          this.dropdown.appendChild(this.current);
          this.valueInput.value = el.value;
          li.classList.add("selected");
        }

        this.ul.appendChild(li);
      });

      this.dropdown.appendChild(this.ul);
      this.dropdown.appendChild(this.valueInput);
      this.$el.parentElement.appendChild(this.dropdown);
    }

    addEvents() {
      this.dropdown.addEventListener("click", e => {
        const target = e.target;
        this.dropdown.classList.toggle("selecting");

        // Save new value only when clicked on li
        if (target.tagName === "LI") {
          this.valueInput.value = target.dataset.value;
          this.current.innerText = target.innerText;
        }
      });
    }
  }
  document.querySelectorAll(".form-group--dropdown select").forEach(el => {
    new FormSelect(el);
  });

  /**
   * Hide elements when clicked on document
   */
  document.addEventListener("click", function(e) {
    const target = e.target;
    const tagName = target.tagName;

    if (target.classList.contains("dropdown")) return false;

    if (tagName === "LI" && target.parentElement.parentElement.classList.contains("dropdown")) {
      return false;
    }

    if (tagName === "DIV" && target.parentElement.classList.contains("dropdown")) {
      return false;
    }

    document.querySelectorAll(".form-group--dropdown .dropdown").forEach(el => {
      el.classList.remove("selecting");
    });
  });

  /**
   * Switching between form steps
   */
  class FormSteps {
    constructor(form) {
      this.$form = form;
      this.$next = form.querySelectorAll(".next-step");
      this.$prev = form.querySelectorAll(".prev-step");
      this.$step = form.querySelector(".form--steps-counter span");
      this.currentStep = 1;

      this.$stepInstructions = form.querySelectorAll(".form--steps-instructions p");
      const $stepForms = form.querySelectorAll("form > div");
      this.slides = [...this.$stepInstructions, ...$stepForms];

      this.init();
    }

    /**
     * Init all methods
     */
    init() {
      this.events();
      this.updateForm();
    }

    /**
     * All events that are happening in form
     */
    events() {
      // Next step
      this.$next.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();
          if (validation(this.currentStep)) {
            this.currentStep++;
          }
          this.updateForm();
        });
      });

      // Previous step
      this.$prev.forEach(btn => {
        btn.addEventListener("click", e => {
          e.preventDefault();

          this.currentStep--;
          this.updateForm();
        });
      });

      // Form submit
      this.$form.querySelector("form").addEventListener("submit", e => this.submit(e));
    }

    /**
     * Update form front-end
     * Show next or previous section etc.
     */
    updateForm() {
      this.$step.innerText = this.currentStep;

      // TODO: Validation


      this.slides.forEach(slide => {
        slide.classList.remove("active");

        if (slide.dataset.step == this.currentStep) {
          slide.classList.add("active");
        }
      });

      this.$stepInstructions[0].parentElement.parentElement.hidden = this.currentStep >= 5;
      this.$step.parentElement.hidden = this.currentStep >= 5;

      // TODO: get data from inputs and show them in summary

      console.log(this.currentStep);
      if (this.currentStep === 5) {
        summaryStep();
      }
    }

  }
  const form = document.querySelector(".form--steps");
  if (form !== null) {
    new FormSteps(form);
  }

  function validation(currentStep) {
    var currentSlide = $('.active');
    var result = false;

    // kasujemy wszystkie informacje o błędach
    $('.error').each(function(){
      $(this).html(' ');
    });

    if (currentStep===1) {
      currentSlide.find('input').each(function () {
        if ($(this).prop('checked')) {
          result = true;
        }
      });
      if (!result) {
        currentSlide.find('.error').html('Zaznacz kategorię przedmiotu który chcesz podarować.');
      }
    }

    if (currentStep===2) {
      if (currentSlide.find('input').prop('value')>0) {
        result = true;
      }
      if (!result) {
        currentSlide.find('.error').html('Podaj ilość worków.');
      }
    }

    if (currentStep===3) {
      currentSlide.find('input').each(function () {
        if ($(this).prop('checked')) {
          result = true;
        }
      });
      if (!result) {
        currentSlide.find('.error').html('Zaznacz Instytucję do której chcesz przekazać paczkę');
      }
    }

    if (currentStep===4) {
      result = true;
      var fields = currentSlide.find('input');
      var errors = currentSlide.find('.error');

      fields.each(function(i){
        if (!$(this).prop('value')) {
          result = false;
          if (i===0) { errors.eq(i).html('Podaj nazwę ulicy i numer domu')}
          if (i===1) { errors.eq(i).html('Podaj miasto')}
          if (i===2) { errors.eq(i).html('Podaj kod pocztowy')}
          if (i===3) { errors.eq(i).html('Podaj numer telefonu')}
          if (i===4) { errors.eq(i).html('Podaj termin odbioru')}
          if (i===5) { errors.eq(i).html('Podaj godzinę odbioru')}
        }
      });
    }
    return result;
  }

  function summaryStep() {

    var caption = $('.quantity').prop('value')+' worki ';
    $('.category').each(function(){
      if ($(this).prop('checked')) {
        caption += $(this).data('name')
      }
      caption += ' ';
    });
    $('#summaryQuantityAndCategories').html(caption);

    caption = "Dla ";
    $('.institution').each(function(){
      if ($(this).prop('checked')) {
        caption += $(this).data('name')
      }
    });
    $('#summaryInstitution').html(caption);

    $('#summaryStreet').html($('.street').prop('value'));
    $('#summaryCity').html($('.city').prop('value'));
    $('#summaryZipCode').html($('.zipCode').prop('value'));
    $('#summaryPhone').html($('.phone').prop('value'));
    $('#summaryDate').html($('.date').prop('value'));
    $('#summaryTime').html($('.time').prop('value'));
    $('#summaryComment').html($('.comment').prop('value'));
  }


});
