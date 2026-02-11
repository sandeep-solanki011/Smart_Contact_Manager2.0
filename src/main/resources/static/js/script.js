console.log("script loaded");

let currentTheme=getTheme();

//initial -->
changeTheme();
//TODO:

function changeTheme()
{
    // set to web page
    document.querySelector('html').classList.add(currentTheme);

    //set  the listener  to change theme button

    const changeThemeButton=document.querySelector('#theme_change_button');
    changeThemeButton.addEventListener("click",(event)=>{
        const oldTheme=currentTheme;
        console.log("change theme button click");

        if(currentTheme === "dark")
        {
           currentTheme="light";
        }else{

            currentTheme="dark";
        }
        setTheme(currentTheme);

        //localstorage main update karenge
        document.querySelector('html').classList.remove(oldTheme);

        document.querySelector('html').classList.add(currentTheme);

        //change the text of button

        changeThemeButton.querySelector("span").textContent=currentTheme=="light"?"Dark" :"Light";
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
//    if(theme)
//     return theme;
// else return "light";
return theme ? theme :"light";
}