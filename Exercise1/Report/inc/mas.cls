\ProvidesClass{inc/mas}
\NeedsTeXFormat{LaTeX2e}[2005/12/01]
\RequirePackage{fixltx2e} % fixes some latex2 issues
\ProcessOptions*\relax
\LoadClass[a4paper]{article}
% -------------------- Page layout dimensions and switches
% \paperwidth  597.50787pt
% \paperheight 845.04684pt
% \textwidth  512.14963pt
% \textheight 731.23584pt
% \oddsidemargin  -29.59087pt
% \evensidemargin -29.59087pt
% \topmargin  -52.36449pt
% \headheight 12.0pt
% \headsep    25.0pt
% \footskip   30.0pt
% \marginparwidth 43.36243pt
% \marginparsep   10.0pt
% \columnsep  22.58437pt
% \skip\footins  9.0pt plus 4.0pt minus 2.0pt
% \hoffset 0.0pt
% \voffset 0.0pt
% \mag 1000
% \@twocolumntrue
% (1in=72.27pt, 1cm=28.45pt)
\usepackage[%
  lmargin=1.5cm,rmargin=1.5cm,tmargin=2cm,bmargin=2cm%
]{geometry}
\setlength{\columnsep}{0.3125in}
\widowpenalty=300
\clubpenalty=300

% These are needed if using pdflatex
\ifx\pdfoutput\@undefined\else
\setlength{\pdfpageheight}{297mm}
\setlength{\pdfpagewidth}{210mm}
\fi

\RequirePackage[T1]{fontenc}
\RequirePackage{textcomp}
\RequirePackage[utf8]{inputenc} % give me åäö
\RequirePackage[english]{babel}
\RequirePackage[scaled=0.92]{helvet}
\renewcommand{\familydefault}{\sfdefault}
\RequirePackage{sectsty} % set header styles
\RequirePackage{pifont} % special itemized lists see psnfss2e.pdf for more info)
\RequirePackage{titling}
\RequirePackage{booktabs}
% \RequirePackage{flushend} % even-columned last page of document
% \flushbottom \twocolumn \sloppy % makes all pages same height
\RequirePackage{lettrine}
\RequirePackage{keyval}
%\RequirePackage{sidecap} % side captions
\RequirePackage{parskip} % empty line between pragraphs
%\RequirePackage{pgfplotstable} `% advanced tables
\RequirePackage{graphicx} % include graphic
\RequirePackage{subfig} % to align figures and pictures with greater easy
%\RequirePackage{eso-pic} % add picture commands (or backgrounds) to every page.
\RequirePackage{eurosym} % Euro Symbol Package for LaTeX  \euro(gives symbol)
% \EUR{10} (gives correct spacing)
\RequirePackage{mdwlist} % advanced lists (enumerate*, itemize*,
% \suspend{itemize*} text \resume{itemize*} \item)
\RequirePackage{amsmath,amsthm,amssymb} % mathematical packages
\RequirePackage{array} %  An extended implementation of the array and tabular
\RequirePackage[sort&compress,longnamesfirst,round]{natbib}
\RequirePackage{color,colortbl} % more color
\RequirePackage{multirow}
\RequirePackage{verbatim,listings} % add source code to your document
\RequirePackage{lastpage} % total page count
\RequirePackage{pdfpages} % to import PDF pages
% \includepdf[pages={2-7}]{/path/file.pdf}
\RequirePackage{ifthen} % to use if then else
\RequirePackage{rotating} % rotate any object of an arbitrary angle
\RequirePackage{setspace} % to change the spacing in different environments
% [doublespace, onehalfspace, singlespace]
\RequirePackage{makeidx} % for making indices
\RequirePackage{wrapfig} % to wrap text around and image
\RequirePackage{inc/named} %fancy referencing
\RequirePackage{blindtext} % only for document design
\RequirePackage[plainpages=false,%
    bookmarks=true,     % show bookmarks bar?
    unicode=true,          % non-Latin characters in Acrobat’s bookmarks
    pdftoolbar=true,        % show Acrobat’s toolbar?
    pdfmenubar=true,        % show Acrobat’s menu?
    pdffitwindow=true,     % window fit to page when opened
    pdfview={Fit},%
    pdfstartview={Fit},    % fits the width of the page to the window
    pdfnewwindow=true,      % links in new window
    colorlinks=true,       % false: boxed links; true: colored links
    linkcolor=black,          % color of internal links
    citecolor=black,        % color of links to bibliography
    filecolor=black,      % color of file links
    urlcolor=black,           % color of external links
    pdfpagelabels,  %
    pdftex,%
    pdfproducer={pdfLaTeX},%
    a4paper=true,%
    pagebackref,%
    pdfpagemode=UseNone]{hyperref} % hyperlinks
\urlstyle{same} % same font for urls as rest of paper
\RequirePackage[all]{hypcap} % correct hyperreferences in table
%\RequirePackage{showkeys} % uncomment to print keys from \label, \ref, etc.
%\RequirePackage{showidx} % shows each index entry in the margin
%\RequirePackage{syntonly} % checks the syntax without producing a pdf
%\syntaxonly %uncomment for debug
%\RequirePackage{flashmovie} % embedding of flash movies into PDF files.
\RequirePackage{ftcap} % Allows \caption at the beginning of a table-environment
%\RequirePackage{ftnxtra}
\RequirePackage{footnote} % For footnotes
\makesavenoteenv{table}
\makesavenoteenv{tabular}
\makesavenoteenv{tabular*}
\makesavenoteenv{figure}
\makesavenoteenv{figure*}

%---------------- Subversion integration ----------------
%\RequirePackage{svn-multi}
%\svnid{$Id$}
%\typeout{{Updated: {\svnfileyear-\svnfilemonth-\svnfileday}}}

% \newif\if@hyperref
% \DeclareOption{hyperref}{%
%         \def\pages{\pageref{@firstpg}--\pageref{@lastpg}}%
%         \def\mypage{\thepage}%
%         \def\@getpagenum#1#2#3#4{#2}%
%         \def\pdfinfo#1#2{\pdfmark{pdfmark=/DOCINFO,Title=#1,Author=#2}}
%         \global\@hyperreftrue
%         }

% variables for placing figures in the right place (same page)
% \renewcommand{\topfraction}{0.85}
% \renewcommand{\textfraction}{0.1}
% \renewcommand{\floatpagefraction}{0.75}

\theoremstyle{definition}
\newtheorem{defn}{Definition}[section]

\definecolor{listinggray}{gray}{0.9}
\definecolor{lbcolor}{rgb}{0.9,0.9,0.9}
\lstset{
  %backgroundcolor=\color{lbcolor},
  tabsize=4,
  rulecolor=,
  language=C,
        basicstyle=\scriptsize,
        upquote=true,
        aboveskip={1.5\baselineskip},
        columns=fixed,
        showstringspaces=false,
        extendedchars=true,
        breaklines=true,
        prebreak = \raisebox{0ex}[0ex][0ex]{\ensuremath{\hookleftarrow}},
        frame=single,
        showtabs=false,
        showspaces=false,
        showstringspaces=false,
        identifierstyle=\ttfamily,
        keywordstyle=\color[rgb]{0,0,1},
        commentstyle=\color[rgb]{0.133,0.545,0.133},
        stringstyle=\color[rgb]{0.627,0.126,0.941},
}

\newcommand{\firstletter}[1]{\textcolor{firstlettercolor}{{\fontfamily{put}%
\fontseries{b}\selectfont #1}}}
\newcommand{\lettrineOptions}{\lettrine[lines=1,loversize=-.07,lraise=0,
findent=-.2em]}

\renewcommand{\thesection}{\bfseries\large \arabic{section}}
\renewcommand{\thesubsection}{\bfseries\normalsize \arabic{subsection}}
% \@startsection {NAME}{LEVEL}{INDENT}{BEFORESKIP}{AFTERSKIP}{STYLE}
%            optional * [ALTHEADING]{HEADING}
%    Generic command to start a section.
%    NAME       : e.g., 'subsection'
%    LEVEL      : a number, denoting depth of section -- e.g., chapter=1,
%                 section = 2, etc.  A section number will be printed if
%                 and only if LEVEL < or = the value of the secnumdepth
%                 counter.
%    INDENT     : Indentation of heading from left margin
%    BEFORESKIP : Absolute value = skip to leave above the heading.
%                 If negative, then paragraph indent of text following
%                 heading is suppressed.
%    AFTERSKIP  : if positive, then skip to leave below heading,
%                       else - skip to leave to right of run-in heading.
%    STYLE      : commands to set style
%  If '*' missing, then increments the counter.  If it is present, then
%  there should be no [ALTHEADING] argument.  A sectioning command
%  is normally defined to \@startsection + its first six arguments.
\def\section{\@startsection {section}{1}{\z@}%
   {14pt plus 2pt minus 2pt}{2pt plus 2pt minus 2pt}%
{\huge\color{sectioncolor}\fontfamily{pag}\fontseries{m}\selectfont}}
\def\subsection{\@startsection {subsection}{2}{\z@}%
  {-3.25ex\@plus -1ex \@minus -.2ex} {1.5ex \@plus .2ex}%
{\large\fontfamily{pag}\fontseries{b}\selectfont}}
\def\subsubsection{\@startsection {subsubsection}{3}{\z@}%
   {0pt plus 0pt minus 0pt}{0.02pt plus 0.02pt minus 0.02pt}%
{\fontfamily{pag}\fontseries{b}\selectfont}}

\setcounter{secnumdepth}{2}% control  section numbering

\AtBeginDocument{
  \hypersetup{pdftitle={\@title},%
    pdfauthor={\the@pdfauthor},%
    pdfsubject={\the@pdfsubject},%
    pdfkeywords={\@keywords}}
}

\def\the@pdfauthor{}
\def\the@pdfsubject{}
\newcommand{\pdfauthor}[1]{\def\the@pdfauthor{#1}}
\newcommand{\pdfsubject}[1]{\def\the@pdfsubject{#1}}

\def\keywords #1 {\gdef\@keywords{#1}} \gdef\@keywords{}
\newcommand{\printkeywords}[1]{\textit{\textbf{Keywords: }\@keywords}}
\def\affiliation#1{\gdef\@affiliation{\textsl{#1}}} \gdef\@affiliation{}

% Color constants.
\definecolor{firstlettercolor}{rgb}{0.40784,0,0}
\definecolor{sectioncolor}{rgb}{0.30784,0,0}

% Notes in the page margins are easily created with the command
% \marginpar{marginal note}
\setlength{\marginparwidth}{0.6in}
\let\oldmarginpar\marginpar
\renewcommand\marginpar[1]{\-\oldmarginpar[\raggedleft\footnotesize #1]%
{\raggedright\footnotesize #1}}

% background picture
\newcommand\BackgroundPic{\put(305,810){\parbox[t][14.4cm]{2.4cm}{\raggedright
\includegraphics[scale=0.45,keepaspectratio]{img/logobig.png}}}}
% user defined commands
\newcommand{\mail}[1]{\href{mailto:#1}{#1}}
\newcommand{\REF}{\Large\ding{109}\normalsize}
\newcommand{\keyterm}[1]{\textbf{#1}}
\newcommand{\firstparagraph}[2]{\lettrineOptions{\firstletter{#1}}{ \space #2}}
\newcommand{\tinylist}{
  \setlength \topsep{0pt}
  \setlength \itemsep{0pt}
  \setlength \parskip{0pt}
  \setlength \parsep{0pt}
}

\newcount\titlenotecount
\global\titlenotecount=0

\global\let\s@btitle\@empty
\global\let\s@btitle\relax
\def\subtitle#1{\gdef\s@btitle{#1}}

\def\@maketitle
   {
   \vspace*{78pt}
   \begin{center}
      {\Huge \bf \@title \par}
        \ifx\s@btitle\@empty
            \relax
        \else
             {\Large \bf \s@btitle \par}
        \fi%
      % additional two empty lines at the end of the title
      \vspace*{48pt}
      {
      \large
      \lineskip 1.5em
      \begin{tabular}[t]{c}
         \@author
      \end{tabular}
      \par
      }
      % additional small space at the end of the author name
      \vskip 1.5em
      {
       \large
      \begin{tabular}[t]{c}
         \@affiliation
      \end{tabular}
      \par
      }
   \end{center}
\clearpage
}

\def\abstract
   {%
   \centerline{\Large \color{sectioncolor} Abstract}%
    \vspace*{-3pt}%
    \dingline{99}%
    \vspace*{-6pt}%
%     \centerline{\rule{0.43\textwidth}{1pt}}%
   \it%
   }

\def\endabstract
   {
   % additional empty line at the end of the abstract
   \vspace*{6pt}
   }

\def\quote{\list{}{\rightmargin\leftmargin}\item[]{\color[gray]{0.3}\Large\ding{
125}}\space\color[gray]{0.1}}
% \let\endquote=\endlist
\def\endquote{\space {\color[gray]{0.3}\Large\ding{126}}\endlist\color[gray]{0}}

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
%
%   USEFUL
%
% pt  a point is 1/72.27 inch, that means about 0.0138 inch or 0.3515 mm.
% bp  a big point is 1/72 inch, that means about 0.0139 inch or 0.3527 mm.
% mm  a millimeter
% cm  a centimeter
% in  inch
% ex  roughly the height of an 'x' in the current font
% em  roughly the width of an 'M' (note the uppercase) of the current font
% \usepackage{datetime}
% \renewcommand{\dateseparator}{-}
% \newcommand{\todayiso}{\the\year \dateseparator \twodigit\month \dateseparator
% \twodigit\day}

% Fancy chapter styles
%\usepackage[Lenny]{fncychap} %Sonny, Lenny, Glenn, Conny, Rejne and Bjarne.

%\RequirePackage{ifpdf}
% And in the document:
% \ifpdf
%     % we are running pdflatex
% \else
%     % we are running latex
% \fi

% Align two tables
%   \begin{minipage}{2in}
%     \begin{tabular}{c}
%       Table1
%     \end{tabular}
%   \end{minipage}
%   \begin{minipage}{2in}
%     \begin{tabular}{c}
%       Table2
%     \end{tabular}
%   \end{minipage}

% Some programs create postscript files without a bounding box. Latex doesn't
% like this. To fix the problem, add a line like this to the top of the
% postscript file:
%%BoundingBox: 50 150 550 650