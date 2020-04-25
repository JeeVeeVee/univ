{-# LANGUAGE CPP #-}
{-# LANGUAGE NoRebindableSyntax #-}
{-# OPTIONS_GHC -fno-warn-missing-import-lists #-}
module Paths_snake (
    version,
    getBinDir, getLibDir, getDynLibDir, getDataDir, getLibexecDir,
    getDataFileName, getSysconfDir
  ) where

import qualified Control.Exception as Exception
import Data.Version (Version(..))
import System.Environment (getEnv)
import Prelude

#if defined(VERSION_base)

#if MIN_VERSION_base(4,0,0)
catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
#else
catchIO :: IO a -> (Exception.Exception -> IO a) -> IO a
#endif

#else
catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
#endif
catchIO = Exception.catch

version :: Version
version = Version [0,0,1,0] []
bindir, libdir, dynlibdir, datadir, libexecdir, sysconfdir :: FilePath

bindir     = "/home/jeeveevee/univ/2deBachelor/functioneelprogrammeren/oefeningen/projecten/snake/.stack-work/install/x86_64-linux/07a5b24c93c30ba192f9dbb3ac26767849a74b3417bf1b41ca41117c196e8fe0/8.6.5/bin"
libdir     = "/home/jeeveevee/univ/2deBachelor/functioneelprogrammeren/oefeningen/projecten/snake/.stack-work/install/x86_64-linux/07a5b24c93c30ba192f9dbb3ac26767849a74b3417bf1b41ca41117c196e8fe0/8.6.5/lib/x86_64-linux-ghc-8.6.5/snake-0.0.1.0-6qUMHKapsbCCyauqE2HOoG-snake"
dynlibdir  = "/home/jeeveevee/univ/2deBachelor/functioneelprogrammeren/oefeningen/projecten/snake/.stack-work/install/x86_64-linux/07a5b24c93c30ba192f9dbb3ac26767849a74b3417bf1b41ca41117c196e8fe0/8.6.5/lib/x86_64-linux-ghc-8.6.5"
datadir    = "/home/jeeveevee/univ/2deBachelor/functioneelprogrammeren/oefeningen/projecten/snake/.stack-work/install/x86_64-linux/07a5b24c93c30ba192f9dbb3ac26767849a74b3417bf1b41ca41117c196e8fe0/8.6.5/share/x86_64-linux-ghc-8.6.5/snake-0.0.1.0"
libexecdir = "/home/jeeveevee/univ/2deBachelor/functioneelprogrammeren/oefeningen/projecten/snake/.stack-work/install/x86_64-linux/07a5b24c93c30ba192f9dbb3ac26767849a74b3417bf1b41ca41117c196e8fe0/8.6.5/libexec/x86_64-linux-ghc-8.6.5/snake-0.0.1.0"
sysconfdir = "/home/jeeveevee/univ/2deBachelor/functioneelprogrammeren/oefeningen/projecten/snake/.stack-work/install/x86_64-linux/07a5b24c93c30ba192f9dbb3ac26767849a74b3417bf1b41ca41117c196e8fe0/8.6.5/etc"

getBinDir, getLibDir, getDynLibDir, getDataDir, getLibexecDir, getSysconfDir :: IO FilePath
getBinDir = catchIO (getEnv "snake_bindir") (\_ -> return bindir)
getLibDir = catchIO (getEnv "snake_libdir") (\_ -> return libdir)
getDynLibDir = catchIO (getEnv "snake_dynlibdir") (\_ -> return dynlibdir)
getDataDir = catchIO (getEnv "snake_datadir") (\_ -> return datadir)
getLibexecDir = catchIO (getEnv "snake_libexecdir") (\_ -> return libexecdir)
getSysconfDir = catchIO (getEnv "snake_sysconfdir") (\_ -> return sysconfdir)

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir ++ "/" ++ name)
