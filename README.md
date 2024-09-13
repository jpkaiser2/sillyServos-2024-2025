# Silly Servos 2024-2025
Code repository for the Silly Servos Robotics Team #24213 at Highland Park High School
<br>
2024-2025 FTC Into the Deep
<br>
GitHub repository created and maintained by Jacob Kaiserman
<br>
<a href="https://github.com/jpkaiser2/SillyServosInProgress">Repository for in-progress code</a>
<br>
<img src="https://jacobkaiserman.com/sillyServos-2023-2024/images/hpRobotics.png" width="30%" style="display:inline;">
<img src="https://jacobkaiserman.com/sillyServos-2024-2025/images/ftcDeepLogo.png" width="20%" style="display:inline;">
<br>
<h1>How the Code Works</h1>
<p>We will add this section later in the season when our code is complete.</p>
<h1>Resources</h1>
<p>Below you can find helpful sites, explanations, and a setup guide on GitHub.</p>
<h2>Helpful Websites</h2>
<ul>
  <li><a href="https://ftc-resources.firstinspires.org/file/ftc/game/manual">Official FTC Game Manual</a></li>
  <li><a href="https://gm0.org">Game Manual 0</a></li>
  <li><a href="https://learnroadrunner.com/">Learn Road Runner</a></li>
  <li><a href="https://www.firstinspires.org/sites/default/files/uploads/resource_library/ftc/onbot-java-guide.pdf">OnBot Java Guide: Electronics Setup to Programming</a></li>
  <li><a href="https://raw.githubusercontent.com/alan412/LearnJavaForFTC/master/LearnJavaForFTC.pdf">Learn Java for FTC</a></li>
  <li><a href="https://ftc-docs.firstinspires.org/en/latest/">FIRST Tech Challenge Documentation</a></li>
  <li><a href="https://portfolios.hivemindrobotics.net/ftc">Example Portfolios</a></li>
  <li><a href="https://github.com/FIRST-Tech-Challenge/FtcRobotController">FtcRobotController</a></li>
  <li><a href="https://www.w3schools.com/java/java_oop.asp">Object-Oriented Programming in Java (W3 Schools)</a></li>
  <li><a href="https://www.reddit.com/r/ftc">FTC Subreddit</a></li>
</ul>
<h2>Using GitHub</h2>
<h3>What is GitHub?</h3>
<p>Imagine GitHub as a digital workspace where you and others can collaborate on building things together. Think of it like a shared online notebook for writing code.</p>
<h3>What can you do with GitHub?</h3>
<p>On GitHub you can:</p>
<ul>
  <li>Store your code: Keep your code organized and safe in the cloud.</li>
  <li>Track changes: See who made what changes to your code and when.</li>
  <li>Collaborate with others: Work on coding projects with other people.</li>
  <li>Learn from others: Explore and learn from code written by others.</li>
</ul>
<p>Key terms:</p>
<ul>
  <li>Repository: This is like a folder where you store your code files.</li>
  <li>Commit: This is a snapshot of your code at a specific point in time.</li>
  <li>Branch: This is a copy of your code where you can make changes without affecting the original.</li>
  <li>Pull request: This is a way to suggest changes to someone else's code.</li>
</ul>
<p>Think of it like writing a book:</p>
<ul>
  <li>The repository is the book itself.</li>
  <li>Each chapter is a branch.</li>
  <li>Saving your progress is a commit.</li>
  <li>Asking a friend to review your chapter is a pull request.</li>
</ul>
<h2>Setting up your Computer with GitHub Desktop & Android Studio</h2>
<p>We use GitHub as our central code repository for the robot. This allows multiple team members to collaborate efficiently on the code. While GitHub can be used for basic editing, we primarily utilize an Integrated Development Environment (IDE) for code development. An IDE is a specialized software application that provides advanced features for writing, testing, and debugging code. Our team uses Android Studio, an IDE specifically designed for Java development, to create and refine our robot's software. Since Android Studio is a desktop application, it runs directly on your local computer and needs to be downloaded. To connect GitHub (on the web) to your IDE (locally on your computer), you will need to download GitHub Desktop. The GitHub desktop GUI is the easiest way to connect to GitHub. You can also use Git in the command line, but our team uses GitHub Desktop since it is easier for beginners.</p>
<h3>Downloading GitHub Desktop & Creating a GitHub Account</h3>
<p>You will need to create a GitHub account to contribute to this repository. Navigate to <a href="https://www.github.com">GitHub.com</a> and create a free account. Next, download <a href="https://github.com/apps/desktop">GitHub Desktop</a> and sign in to your newly created account. You now have GitHub all setup!</p>
<h3>Cloning the GitHub Repository</h3>
<p>To edit the repository in Android Studio, you need to have your own local copy of it. This is called "cloning" a repository. In GitHub Desktop, click on the upper left-hand corner where it says "current repository". Click on the "Add" button and select "clone repository" from the dropdown menu. Then, click the "URL" tab and enter <code>jpkaiser2/sillyServos-2024-2025</code>. Below that, choose a local path. This is where you will access the code files from your computer. Choose somewhere you will remember, such as your desktop. Click the "clone" button and you should be done!</p>
<h3>Installing Android Studio and Opening the Cloned Repository</h3>
<p>You will now need to download <a href="https://developer.android.com/studio">Android Studio</a>. Once it is installed, open the app and click on File>Open. You can then select the path of the cloned repository (from the previous step). The repository is now editable in Android Studio!</p>
<h3>Editing the Code</h3>
<p>You can edit the code in Android Studio. More information on the code structure can be found farther down on this page. Once you edit the code, you will need to push it to GitHub to publish your changes. If you haven't already, save your code in Android Studio with command+s (Mac) or ctrl+s (Windows & GNU/Linux). Navigate to GitHub Desktop and write a short summary of your code. It is a good idea to document your code, especially if you are working on it with others. Then, click "commit to main" to add your changes. Then click "push origin" to add it to GitHub. If you do not see the "push origin" button, that means someone else has made a change to the repository. Click on "pull origin" to get their changes and then click "push origin" to add your changes.</p>
<h2>Road Runner</h2>
<ul>
  <li>Road Runner drive constants explanation: <a href="https://learnroadrunner.com/drive-constants.html#drive-constants" target="_blank">https://learnroadrunner.com/drive-constants.html#drive-constants</a></li>
</ul>
<h2>Mecanum Wheels & Driver-Controlled Period</h2>
<ul>
  <li>Mecanum Wheels diagram for coding aid: <a href="https://learnroadrunner.com/assets/img/gobilda-mecanum-chart.f1c03ff0.png" target="_blank">https://learnroadrunner.com/assets/img/gobilda-mecanum-chart.f1c03ff0.png</a></li>
  <img src="https://learnroadrunner.com/assets/img/gobilda-mecanum-chart.f1c03ff0.png" width="" style="display:inline;">
</ul>
