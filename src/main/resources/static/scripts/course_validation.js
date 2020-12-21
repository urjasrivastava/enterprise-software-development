var enrollList = []

function setupCourseList() {
    var checkboxes = document.querySelectorAll("input[type='checkbox']");
    checkboxes.forEach(checkbox => {
        // console.log(checkbox.name + "\t" + checkbox.id + "\t" + checkbox.value + "\n")
        if(checkbox.id.includes("-")) {
            console.log("De-enroll")
            enrollList.push(checkbox)
        }
    });
}

function enrollCheckboxOnClick(checkbox) {
    // alert("Clicked on check box with id " + checkbox.id);
    if(checkbox.checked)
        enrollList.push(checkbox)
    else
        enrollList.splice(enrollList.indexOf(checkbox), 1)
}

function deenrollCheckboxOnClick(checkbox) {
    // alert("Clicked on check box with id " + checkbox.id);

    if(checkbox.checked) {
        enrollList.splice(enrollList.indexOf(checkbox), 1)
    }
    else {
        enrollList.push(checkbox)
    }
}

function courseValidation() {
    if(enrollList.length >= 4 && enrollList.length <= 6) {
        alert("Your choices will be saved!");
        return true;
    } else {
        alert("You have to enroll into a minimum of 4 courses and can enroll into a maximum of 6 courses");
        return false;
    }


}
