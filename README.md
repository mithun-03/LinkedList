PASTEBIN
Search...

LOGIN SIGN UP
Advertisement
maverickcygnoux
Voting by Maverick v2
MAVERICKCYGNOUX
FEB 10TH, 2024
8
0
NEVER
ADD COMMENT
Not a member of Pastebin yet? Sign Up, it unlocks many cool features!
2.97 KB | Source Code |  
  
// ==UserScript==
// @name         Voting by Maverick
// @namespace    https://your.namespace.com
// @version      2.0
// @description  Automatically it will reload for every 10 seconds .. Works both PC and Mobile
// @author       Maverick
// @match        https://www.galatta.com/dream-lover-2024/*
// @grant        none
// ==/UserScript==
 
(function() {
    'use strict';
 
    // XPath expressions of elements to be bypassed
    var xpathExpressions = [
        "/html/body/div[2]/section/div/div/div/div/div[3]",
        "/html/body/div[2]/section/div/div/div/div/div[4]"
    ];
 
    // XPath expression of the button to be clicked
    var buttonXPath = "/html/body/div[2]/section/div/div/div/div/form/div[11]/button";
 
    // XPath expression of the contestant to be selected automatically
    var contestantXPath = '//*[@id="lbl_dream_crush200"]/div'; // Change this XPath accordingly
 
    // Function to bypass elements based on XPath expressions
    function bypassElements() {
        xpathExpressions.forEach(function(xpath) {
            var elements = document.evaluate(xpath, document, null, XPathResult.ORDERED_NODE_SNAPSHOT_TYPE, null);
            for (var i = 0; i < elements.snapshotLength; i++) {
                var element = elements.snapshotItem(i);
                element.parentNode.removeChild(element); // Remove the element from the DOM
            }
        });
    }
 
    // Function to click the button based on XPath expression
    function clickButton() {
        var button = document.evaluate(buttonXPath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
        if (button) {
            button.click(); // Click the button
        }
    }
 
    // Function to automatically select the contestant
    function selectContestant() {
        var contestant = document.evaluate(contestantXPath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
        if (contestant) {
            contestant.click(); // Click the contestant
        }
    }
 
    // Function to reload the webpage every 10 seconds
    function reloadPage() {
        setTimeout(function() {
            window.location.reload();
        }, 10000); // Reload every 10 seconds (10000 milliseconds)
    }
 
    // Call the bypassElements function when the page loads or reloads
    window.addEventListener('load', function() {
        bypassElements();
        selectContestant(); // Automatically select the contestant
        setInterval(clickButton, 100); // Click the button continuously at 100 milliseconds interval
        reloadPage(); // Reload the webpage every 10 seconds
    });
    window.addEventListener('DOMContentLoaded', function() {
        bypassElements();
        selectContestant(); // Automatically select the contestant
        setInterval(clickButton, 100); // Click the button continuously at 100 milliseconds interval
        reloadPage(); // Reload the webpage every 10 seconds
    });
})();
