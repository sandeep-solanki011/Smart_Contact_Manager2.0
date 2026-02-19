console.log("script loaded");

let currentTheme=getTheme();

//initial -->

document.addEventListener("DOMContentLoaded",() =>
{
  changeTheme();
})


//TODO:

function changeTheme()
{

    // set to web page
    document.querySelector("html").classList.add(currentTheme);

    changePageTheme(currentTheme,currentTheme);

    //set  the listener  to change theme button

    const changeThemeButton=document.querySelector("#theme_change_button");
    console.log(changeThemeButton);

    changeThemeButton.textContent = currentTheme === "light" ? "Dark" : "Light";

    
     changeThemeButton.addEventListener("click",(event)=>{
        let oldTheme=currentTheme;
  

        if(currentTheme === "dark")
        {
           currentTheme="light";
        }else{

            currentTheme="dark";
        }
      
           changePageTheme(currentTheme,oldTheme);
    });
   
}

//set theme to localstorage

function setTheme(theme)
{
    localStorage.setItem("theme",theme);
}

//get theme from localstorage

function getTheme()
{
    let theme=localStorage.getItem("theme");
return theme ? theme :"light";
}

//change current page theme

function changePageTheme(theme,oldTheme)
{
            //localstorage main update karenge
      setTheme(currentTheme);

//remove the current theme
        document.querySelector('html').classList.remove(oldTheme);
//set the current theme
 document.querySelector('html').classList.add(currentTheme);

document.querySelector("#theme_change_button").textContent = theme === "light" ? "Dark" : "Light";
}

